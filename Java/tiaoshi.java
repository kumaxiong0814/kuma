package com.a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FixedLengthFileProcessor {

    /**
     * 将固定长度文件转换为 CSV
     * @param fieldConfig 字段配置（字段名称和长度）
     * @param inputFile 输入文件路径
     * @param outputFile 输出 CSV 文件路径
     * @throws IOException 处理文件时的异常
     */
    public static void convertToCSV(String[][] fieldConfig, String inputFile, String outputFile) throws IOException {
        // 读取固定长度文件
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头
            List<String> headers = new ArrayList<>();
            for (String[] field : fieldConfig) {
                headers.add(field[0]); // 添加字段名
            }
            headers.add("Empty_Fields"); // 添加空字段列
            writer.write(String.join(",", headers));
            writer.newLine();

            // 逐行读取文件并处理
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> values = new ArrayList<>();
                List<String> emptyFields = new ArrayList<>();

                int start = 0;
                for (String[] field : fieldConfig) {
                    String fieldName = field[0];
                    int length = Integer.parseInt(field[1]);
                    String value = line.substring(start, Math.min(start + length, line.length())).trim();
                    values.add(value);

                    // 检查字段是否为空
                    if (value.isEmpty()) {
                        emptyFields.add(fieldName);
                    }
                    start += length;
                }

                // 添加空字段信息到最后一列
                values.add(emptyFields.isEmpty() ? "None" : String.join(";", emptyFields));

                // 写入 CSV 行
                writer.write(String.join(",", values));
                writer.newLine();
            }
        }
    }
}