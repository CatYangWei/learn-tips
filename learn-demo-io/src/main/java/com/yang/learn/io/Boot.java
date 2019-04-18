package com.yang.learn.io;

/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/4/18 13:45
 */
public class Boot {
    private static String path = "E:\\data\\test-data\\fileWriter4.txt";

    private static int lineNum = 10000*1000*10;

    public static void main(String[] args)throws Exception {
        DataMaker maker = new DataMaker(lineNum,path);
        maker.memoryMapWriter();
    }
}
