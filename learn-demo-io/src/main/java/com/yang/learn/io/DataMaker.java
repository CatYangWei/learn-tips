package com.yang.learn.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author coffezcat
 * @title: DataMaker
 * @description: 数据生成
 * @date 2019/4/18 13:46
 */
public class DataMaker {
    //生成文件记录数
    private long lineNum;

    //生成文件路径
    private String path;

    //占位符
    private static final String PLACE_HOLDER = "+++++++++++++++++++++++++++++++++++++++++++++++++++++";

    public DataMaker(long lineNum,String path){
        this.lineNum = lineNum;
        this.path = path;
    }

    /**
     * 普通IO生成
     * */
    public long fileWriter()throws Exception{
        File file = makeFile(this.path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        long start = System.currentTimeMillis();
        for (int i=1;i<=this.lineNum;i++){
            bufferedWriter.append(String.valueOf(i)+PLACE_HOLDER);
            bufferedWriter.newLine();
        }
        long end = System.currentTimeMillis();
        bufferedWriter.close();
        fileWriter.close();
        System.out.println("cost time:"+(end-start));
        return end-start;
    }

    /**
     * RandomAccessFile
     * */
    public long randAccessFileWriter()throws Exception{
        File file = makeFile(this.path);
        RandomAccessFile rf = new RandomAccessFile(this.path,"rw");
        long start = System.currentTimeMillis();
        for (int i=1;i<=this.lineNum;i++){
            rf.writeChars(i+PLACE_HOLDER);
        }
        rf.close();
        long end = System.currentTimeMillis();
        System.out.println("cost time:"+(end-start));
        return end;
    }

    /**
     *内存映射写入文件
     * */
    public long memoryMapWriter()throws Exception{
        File file = makeFile(this.path);
        long start = System.currentTimeMillis();
        RandomAccessFile rf = new RandomAccessFile(this.path,"rw");
        FileChannel fc = rf.getChannel();
        long length = ((lineNum+PLACE_HOLDER+"\r\n").getBytes()).length;
        MappedByteBuffer mappedByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE,0,length*lineNum);

        for (int i=1;i<=this.lineNum;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(PLACE_HOLDER).append("\r\n");
            mappedByteBuffer.put(sb.toString().getBytes());
        }
        rf.close();
        long end = System.currentTimeMillis();
        System.out.println("cost time:"+(end-start));
        return end;
    }

    /**
     * 创建文件夹
     * */
    private File makeFile(String path)throws Exception{
        File newFile = new File(path);
        if(!newFile.exists()){
            newFile.createNewFile();
        }
        return newFile;
    }
}
