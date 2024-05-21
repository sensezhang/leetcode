package com.chehejia.letcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PrintLastN {
    public static void main(String[] args) {
        //String filePath = "C:\\Users\\john\\Desktop\\Exam\\test-files\\large.txt";
        String filePath = "C:\\Users\\john\\Desktop\\Exam\\test-files\\one-line.txt";
        //String filePath = "C:\\Users\\john\\Desktop\\Exam\\test-files\\empty.txt";
        PrintLastN print = new PrintLastN();
        print.printLastN(filePath, 5);
    }
    public void printLastN(String fileAbsPath, int n){
        File file = new File(fileAbsPath);
        if(!file.exists()){
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            long length = randomAccessFile.length();
            if(length == 0L){
                return;
            }
            long index = length - 1;
            while(index > 0 && n > 0){
                randomAccessFile.seek(index);
                index--;
                if(randomAccessFile.readByte() == '\n'){
                    n--;
                }
            }
            if(index == 0){
                randomAccessFile.seek(0);
            }
            byte[] bytes = new byte[(int) (length - index)];
            randomAccessFile.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(randomAccessFile != null){
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}