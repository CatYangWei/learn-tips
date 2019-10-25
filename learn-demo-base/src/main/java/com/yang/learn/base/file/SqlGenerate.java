package com.yang.learn.base.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author coffezcat
 * @title: SqlGenerate
 * @description: TODO
 * @date 2019-10-11 9:33
 */
public class SqlGenerate {

    static final String PATH = "F:\\亚信\\map.txt";
    static final String SQL_TEMPLATE="INSERT into COLUMN_VALUE_MAP (ID,COLUMN_NUM,CONDITION,RESULT,REMARK,ICON) \n" +
            "VALUES(SEQ1,2015,'=','%s','%s','%s');";

    static final String OUT_PATH = "F:\\亚信\\map-new.sql";


    static long id = 470022211;


    public static void main(String[] args)throws Exception {


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT_PATH),"UTF-8"));

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(PATH),"UTF-8"));

        String line = null;
        while ((line = br.readLine())!= null){
            String[] lineArr = line.split("\t");
            String icon = lineArr[0]+"-"+lineArr[1];
            String sql = String.format(SQL_TEMPLATE,lineArr[3],lineArr[2],icon);
            bw.write(sql);
            bw.newLine();
        }
        bw.close();

    }
}
