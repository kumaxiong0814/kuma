
package com.a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FixedLengthFileProcessor {

    /**
     * 将固定长度文件转换为 CSV，并检查字段空值
     *
     * @param fieldConfig 字段配置，每个字段包含 {"字段名称", "字段长度"}
     * @param inputFile   输入的固定长度文件路径
     * @param outputFile  输出的 CSV 文件路径
     * @throws IOException 如果文件读取或写入时发生错误
     */
    public static void convertToCSV(String[][] fieldConfig, String inputFile, String outputFile) throws IOException {
        // 读取固定长度文件
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头
            List<String> headers = new ArrayList<>();
            for (String[] field : fieldConfig) {
                headers.add(field[0]);
            }
            headers.add("Empty_Check");
            headers.add("Empty_Fields");
            writer.write(String.join(",", headers));
            writer.newLine();

            // 逐行读取文件并处理
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> values = new ArrayList<>();
                boolean hasEmptyField = false;
                List<String> emptyFields = new ArrayList<>();

                int start = 0;
                for (String[] field : fieldConfig) {
                    int length = Integer.parseInt(field[1]); // 获取字段长度
                    String value = line.substring(start, Math.min(start + length, line.length())).trim();
                    values.add(value);

                    if (value.isEmpty()) {
                        hasEmptyField = true;
                        emptyFields.add(field[0]); // 记录空字段名称
                    }
                    start += length;
                }

                // 添加空值检查结果
                values.add(hasEmptyField ? "Yes" : "No");

                // 添加具体空字段信息
                values.add(String.join(";", emptyFields));

                // 写入 CSV 行
                writer.write(String.join(",", values));
                writer.newLine();
            }
        }
    }
}