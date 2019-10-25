package com.yang.learn.algorithm.sort;

import java.util.logging.Level;

/**
 * @author coffezcat
 * @title: SortUtils
 * @description: TODO
 * @date 2019-10-09 12:52
 */
public class SortUtils {


    /**
     * 冒泡排序 依次比较两个，将小的往上冒
     * */
    public static int[] bubbleSort(int[] args){
        int len = args.length;
        for (int i=0;i<len;i++){
            for (int j=len-1;j>i;j--){
                if(args[j]<args[j-1]){
                    swap(args,j,j-1);
                }
            }
        }

        return args;
    }


    /**
     * 插入排序
     * */
    public static int[] insertSort(int[] args){
        int c = args.length;
        for (int i=1;i<c;i++){

            int k;
            int tmp = args[i];
            //从当前位置前一位开始

            for (k=i-1;k>=0;k--){
                if(args[k]>tmp){
                    //如果比当前位置大则后移
                    args[k+1] =args[k];
                    //将当前位前移
                    args[k]=tmp;
                }
            }

        }
        return args;
    }

    /**
     * shell排序
     * */
    public static int[] shellSort(int arr[]) {

        int len = arr.length;
        //每次选择一个gap，对相隔gap的数进行插入排序
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < len; i = i + gap) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap&&(j-gap>=0) && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * 每次选择一个小的排到最前面
     * */
    public static void selectSort(){

    }
    /**
     * 选准一个基准值大的在左边 小的在右边
     * */
    public static void quickSort(){

    }
    /**
     *堆排序
     * */
    public static void heapSort(){

    }

    private static void swap(int[] args,int i,int j){
        int temp = args[i];
        args[i]= args[j];
        args[j]=temp;
    }

    public static void print(int[] args){
        for (int num:args){
            System.out.print(num);
            System.out.print("  ");
        }
    }

    public static int[] nums = {7,98,76,12,5,89,2,10,11};

    public static void main(String[] args) {
        //print(insertSort(nums));
        //print(bubbleSort(nums));
        print(shellSort(nums));
    }
}
