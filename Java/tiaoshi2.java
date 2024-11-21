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

        // 配置文件类型：固定长度文件和可变长度文件
        Map<String, FileType> fileTypeConfig = Map.of(
            "1", FileType.FIXED_LENGTH,
            "2", FileType.FIXED_LENGTH,
            "3", FileType.FIXED_LENGTH,
            "4", FileType.FIXED_LENGTH,
            "5", FileType.FIXED_LENGTH,
            "6", FileType.VARIABLE_LENGTH,
            "7", FileType.VARIABLE_LENGTH,
            "8", FileType.VARIABLE_LENGTH,
            "9", FileType.VARIABLE_LENGTH,
            "10", FileType.VARIABLE_LENGTH
        );

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

                try {
                    // 根据文件名配置处理
                    FileType fileType = fileTypeConfig.getOrDefault(fileName, FileType.UNKNOWN);
                    if (fileType == FileType.FIXED_LENGTH) {
                        System.out.println("处理固定长度文件：" + fileName);
                        processFixedLengthFile(file, outputFile);
                    } else if (fileType == FileType.VARIABLE_LENGTH) {
                        System.out.println("处理可变长度文件：" + fileName);
                        processVariableLengthFile(file, outputFile);
                    } else {
                        System.out.println("无法识别的文件类型，跳过：" + fileName);
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
    public static void processFixedLengthFile(File inputFile, String outputFile) throws IOException {
        // 定义固定长度字段配置（根据文件需求调整）
        String[][] fieldConfig = {
            {"ContractNumber", "10"},
            {"DeliveryScheduledDate", "8"},
            {"AutoReplenishmentNumber", "7"},
            {"OrderSourceName", "2"}
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头
            List<String> headers = new ArrayList<>();
            for (String[] field : fieldConfig) {
                headers.add(field[0]);
            }
            writer.write(String.join(",", headers));
            writer.newLine();

            // 逐行解析并写入
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> values = new ArrayList<>();
                int start = 0;

                for (String[] field : fieldConfig) {
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
    public static void processVariableLengthFile(File inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头（根据需求设置）
            writer.write("Field1,Field2,Field3,...");
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
        VARIABLE_LENGTH,
        UNKNOWN
    }
}
