package com.a;

import java.io.*;
import java.util.*;

public class FileProcessorApp {

    public static void main(String[] args) {
        // 输入和输出目录
        String inputFolder = "C:\\path\\to\\input\\";
        String outputFolder = "C:\\path\\to\\output\\";

        // 确保输出目录存在
        File outputDir = new File(outputFolder);
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            System.err.println("输出文件夹创建失败：" + outputFolder);
            return;
        }

        // 配置每个文件的字段定义
        Map<String, FieldConfig> fieldConfigMap = new HashMap<>();
        fieldConfigMap.put("0275", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
            {"ContractNumber", "10"},
            {"DeliveryScheduledDate", "8"},
            {"OrderSourceName", "2"}
        }));
        fieldConfigMap.put("0288", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
            {"Field1"}, {"Field2"}, {"Field3"}
        }));
        fieldConfigMap.put("0313", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
            {"Name"}, {"Address"}, {"PhoneNumber"}
        }));
        fieldConfigMap.put("0290", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
            {"ItemCode", "15"},
            {"Quantity", "5"},
            {"Price", "10"}
        }));

        // 添加其他文件的字段配置
        // ...

        // 遍历输入目录的文件
        File folder = new File(inputFolder);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("输入目录中没有文件。");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String outputFile = outputFolder + fileName + ".csv";

                // 加载字段配置
                FieldConfig config = fieldConfigMap.get(fileName);
                if (config == null) {
                    System.out.println("未找到字段配置，跳过文件：" + fileName);
                    continue;
                }

                try {
                    if (config.getFileType() == FileType.FIXED_LENGTH) {
                        System.out.println("处理固定长度文件：" + fileName);
                        processFixedLengthFile(file, outputFile, config.getFieldDefinitions());
                    } else if (config.getFileType() == FileType.VARIABLE_LENGTH) {
                        System.out.println("处理可变长度文件：" + fileName);
                        processVariableLengthFile(file, outputFile, config.getFieldDefinitions());
                    }
                } catch (Exception e) {
                    System.err.println("处理文件出错：" + fileName + "，错误原因：" + e.getMessage());
                }
            }
        }
    }

    /**
     * 处理固定长度文件
     */
    public static void processFixedLengthFile(File inputFile, String outputFile, String[][] fieldDefinitions) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头
            List<String> headers = new ArrayList<>();
            for (String[] field : fieldDefinitions) {
                headers.add(field[0]);
            }
            writer.write(String.join(",", headers));
            writer.newLine();

            // 逐行解析并写入
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> values = new ArrayList<>();
                int start = 0;

                for (String[] field : fieldDefinitions) {
                    int length = Integer.parseInt(field[1]);
                    String value = line.substring(start, Math.min(start + length, line.length())).trim();
                    values.add(value);
                    start += length;
                }

                writer.write(String.join(",", values));
                writer.newLine();
            }
        }
    }

    /**
     * 处理可变长度文件
     */
    public static void processVariableLengthFile(File inputFile, String outputFile, String[][] fieldDefinitions) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头
            List<String> headers = new ArrayList<>();
            for (String[] field : fieldDefinitions) {
                headers.add(field[0]);
            }
            writer.write(String.join(",", headers));
            writer.newLine();

            // 逐行解析并写入
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");
                writer.write(String.join(",", fields));
                writer.newLine();
            }
        }
    }

    /**
     * 文件类型枚举
     */
    enum FileType {
        FIXED_LENGTH,
        VARIABLE_LENGTH
    }

    /**
     * 字段配置类
     */
    static class FieldConfig {
        private final FileType fileType;
        private final String[][] fieldDefinitions;

        public FieldConfig(FileType fileType, String[][] fieldDefinitions) {
            this.fileType = fileType;
            this.fieldDefinitions = fieldDefinitions;
        }

        public FileType getFileType() {
            return fileType;
        }

        public String[][] getFieldDefinitions() {
            return fieldDefinitions;
        }
    }
}