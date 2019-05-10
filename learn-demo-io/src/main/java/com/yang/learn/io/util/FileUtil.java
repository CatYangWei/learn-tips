package com.yang.learn.io.util;

import java.io.File;

/**
 * @author coffezcat
 * @title: FileUtil
 * @description: TODO
 * @date 2019/5/10 10:32
 */
public class FileUtil {
    /**
     * 创建文件夹
     * */
    public static File makeFile(String path)throws Exception{
        File newFile = new File(path);
        if(!newFile.exists()){
            newFile.createNewFile();
        }
        return newFile;
    }
}
