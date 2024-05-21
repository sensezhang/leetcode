package com.chehejia.letcode;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParseCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\john\\Desktop\\Exam\\csv.txt";
        ParseCsv parse = new ParseCsv();
        parse.parseCsv(filePath);
    }

    public void parseCsv(String fileAbsPath){
        BufferedReader br = null;
        BufferedWriter bw = null;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
        try {
            File file = new File(fileAbsPath);
            if(!file.exists()){
                return;
            }
            File output = new File("C:\\Users\\john\\Desktop\\Exam\\output.txt");
            if(!output.exists()){
                output.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(output));
            String content;
            while((content = br.readLine()) != null){
                content = parseContent(content, format1, format2);
                bw.write(content);
                bw.write("\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String parseContent(String content, SimpleDateFormat format1, SimpleDateFormat format2){
        String[] temp = content.split(",");
        String[] value = new String[5];
        int index = 0;
        String tempContent = "";
        for (String s : temp) {
            if (!s.contains("\"")) {
                if (!"".equals(tempContent)) {
                    value[index++] = tempContent.substring(1, tempContent.length() - 2);
                    tempContent = "";
                }
                value[index++] = s;
            } else {
                tempContent += s + ",";
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++){
            String str = value[i];
            if(i==4){
                try {
                    str = format2.format(format1.parse(str));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (str.contains(",") || str.contains("\"")) {
                if (str.contains("\"")) {
                    str = str.replace("\"", "\"\"");
                }
            }
            if(i == 1 || i == 2){
                str = "'" + str + "'";
            }
            sb.append(str).append("\t");

        }

        return sb.toString();
    }
}