package com.yang.learn.base.datatype;

import org.roaringbitmap.RoaringBitmap;
import org.roaringbitmap.buffer.ImmutableRoaringBitmap;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/**
 * @author coffezcat
 * @title: RoaringBitmapExample
 * @description: TODO
 * @date 2019-09-03 9:37
 */
public class RoaringBitmapExample {

    private static String  path = "E:\\data\\out.txt";

    public static void main(String[] args)throws Exception {
        RoaringBitmap rr = new RoaringBitmap();
        rr.add(158);
        System.out.println(rr.select(3));
        System.out.println(rr.rank(3));
        System.out.println(rr.contains(6));
        System.out.println(rr.getLongCardinality());
        FileOutputStream fos = new FileOutputStream(path);
        DataOutputStream dos = new DataOutputStream(fos);
        rr.serialize(dos);
        dos.flush();
        dos.close();

//        FileInputStream fi = new FileInputStream(path);
//        DataInputStream di = new DataInputStream(fi);
//        byte[] bytes = new byte[di.available()];
//        di.read(bytes,0,di.available());
//        ByteBuffer bb = ByteBuffer.wrap(bytes);
//        ImmutableRoaringBitmap immutableRoaringBitmap = new ImmutableRoaringBitmap(bb);
//        RoaringBitmap rr = new RoaringBitmap(immutableRoaringBitmap);
//        System.out.println(rr.select(3));
//        System.out.println(rr.rank(3));
//        System.out.println(rr.contains(6));
    }
}
