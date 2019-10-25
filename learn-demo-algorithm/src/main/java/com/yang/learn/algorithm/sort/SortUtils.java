package com.yang.learn.algorithm.sort;

/**
 * @author coffezcat
 * @title: SortUtils
 * @description: TODO
 * @date 2019-10-09 12:52
 */
public class SortUtils {
    public static Integer[] insertSort(Integer[] args){
        int c = args.length;
        for (int i=1;i<c;i++){
            int k;
            for (k=i-1;k>0;k--){
                if(args[i]>args[k]){

                }
            }
        }
        return args;
    }



    private void swap(Integer[] args,int i,int j){
        int temp = args[i];
        args[i]= args[j];
        args[j]=temp;
    }
}
