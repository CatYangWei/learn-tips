package com.yang.learn.io;

/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/4/18 13:45
 */
public class Boot {
    private static String path = "E:\\data\\source-data\\31154_user_1532421480028.txt";

    private static int lineNum = 30000*100;

    public static void main(String[] args)throws Exception {
        DataMaker maker = new DataMaker(lineNum,path);
        maker.fileWriter();
    }
}
