package com.a;

import java.util.HashMap;
import java.util.Map;

public class FixedLengthToCSVApp {

    public static void main(String[] args) {
        // 定义文件字段配置，key 是文件名，value 是对应的字段配置
        Map<String, String[][]> fileConfigurations = new HashMap<>();
        
        // 文件 1 的字段配置
        fileConfigurations.put("File1.txt", new String[][]{
                {"ContractNumber", "10"},
                {"DeliveryScheduledDate", "8"},
                {"AutoReplenishmentNumber", "7"},
                {"OrderSourceName", "2"},
                {"SpecifiedTime", "9"},
                {"UrgentFlag", "1"},
                {"CollectionFlag", "1"},
                {"NextVisitDate", "8"},
                {"SalesResponsibleName", "20"},
                {"BuildingName", "34"}
        });

        // 文件 2 的字段配置
        fileConfigurations.put("File2.txt", new String[][]{
                {"FieldA", "15"},
                {"FieldB", "20"},
                {"FieldC", "10"},
                {"FieldD", "5"},
                {"FieldE", "30"}
        });

        // 添加剩余文件配置（示例，需按实际需求补充）
        fileConfigurations.put("File3.txt", new String[][]{
                {"OrderId", "12"},
                {"CustomerName", "25"},
                {"Address", "50"}
        });

        // 可重复添加 File4.txt 到 File10.txt 的配置
        // ...

        // 批量处理所有文件
        String inputFolder = "C:\\path\\to\\input\\";  // 输入文件夹路径
        String outputFolder = "C:\\path\\to\\output\\"; // 输出文件夹路径

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
