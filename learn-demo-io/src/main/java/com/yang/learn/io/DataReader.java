package com.yang.learn.io;

import java.io.*;

/**
 * @author coffezcat
 * @title: DataReader
 * @description: TODO
 * @date 2019/4/25 14:21
 */
public class DataReader {

    // 由统一运行平台提供的分隔符 不是乱码 不要删除
    private static final String SEPERATOR = "�";

    static String path = "C:\\Users\\APPLE\\Desktop\\i_10000_20190424_IOP-F10001_00_001.dat";
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "GBK" );
        BufferedReader br = new BufferedReader(isr);
        String line =  br.readLine();
        System.out.println(line);
        String[] lines = line.split(SEPERATOR);
        System.out.println(lines.length);
        System.out.println(lines);
    }
}
