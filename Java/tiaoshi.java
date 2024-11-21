package com.a;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FixedLengthToCSVApp {

    public static void main(String[] args) {
        // 定义文件字段配置
        Map<String, String[][]> fileConfigurations = new HashMap<>();
        fileConfigurations.put("FSNLO0001", new String[][]{
            {"ContractNumber", "10"},
            {"DeliveryScheduledDate", "8"},
            {"AutoReplenishmentNumber", "7"},
            {"OrderSourceName", "2"},
            {"SpecifiedTime", "9"}
        });

        fileConfigurations.put("FSNLO0002", new String[][]{
            {"FieldA", "15"},
            {"FieldB", "20"},
            {"FieldC", "10"},
            {"FieldD", "5"}
        });

        // 输入和输出文件夹路径
        String inputFolder = "C:\\path\\to\\input\\";
        String outputFolder = "C:\\path\\to\\output\\";

        // 确保输出目录存在
        File outputDir = new File(outputFolder);
        if (!outputDir.exists()) {
            if (outputDir.mkdirs()) {
                System.out.println("输出文件夹已创建：" + outputFolder);
            } else {
                System.err.println("输出文件夹创建失败，请检查路径：" + outputFolder);
                return;
            }
        }

        // 扫描输入目录下的所有文件
        File folder = new File(inputFolder);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("输入目录中没有文件。");
            return;
        }

        // 批量处理文件
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileConfigurations.containsKey(fileName)) {
                    String[][] fieldConfig = fileConfigurations.get(fileName);
                    String inputFile = file.getAbsolutePath();
                    String outputFile = outputFolder + fileName + ".csv";

                    try {
                        FixedLengthFileProcessor.convertToCSV(fieldConfig, inputFile, outputFile);
                        System.out.println("成功转换文件：" + inputFile + " -> " + outputFile);
                    } catch (Exception e) {
                        System.err.println("处理文件出错：" + inputFile + "，错误原因：" + e.getMessage());
                    }
                } else {
                    System.out.println("文件未配置字段定义，跳过：" + fileName);
                }
            }
        }
    }
}