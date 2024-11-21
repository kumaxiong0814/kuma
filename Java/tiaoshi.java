package com.a;

import java.util.HashMap;
import java.util.Map;

public class FixedLengthToCSVApp {

    public static void main(String[] args) {
        // 定义文件字段配置
        Map<String, String[][]> fileConfigurations = new HashMap<>();
        fileConfigurations.put("File1.txt", new String[][]{
            {"ContractNumber", "10"},
            {"DeliveryScheduledDate", "8"},
            {"AutoReplenishmentNumber", "7"},
            {"OrderSourceName", "2"},
            {"SpecifiedTime", "9"}
        });

        fileConfigurations.put("File2.txt", new String[][]{
            {"FieldA", "15"},
            {"FieldB", "20"},
            {"FieldC", "10"},
            {"FieldD", "5"}
        });

        // 添加更多文件字段配置
        // ...

        // 输入输出路径
        String inputFolder = "C:\\path\\to\\input\\";
        String outputFolder = "C:\\path\\to\\output\\";

        // 批量处理文件
        for (Map.Entry<String, String[][]> entry : fileConfigurations.entrySet()) {
            String inputFile = inputFolder + entry.getKey();
            String outputFile = outputFolder + entry.getKey().replace(".txt", ".csv");
            String[][] fieldConfig = entry.getValue();

            try {
                FixedLengthFileProcessor.convertToCSV(fieldConfig, inputFile, outputFile);
                System.out.println("成功转换文件：" + inputFile + " -> " + outputFile);
            } catch (Exception e) {
                System.err.println("处理文件出错：" + inputFile + "，错误原因：" + e.getMessage());
            }
        }
    }
}