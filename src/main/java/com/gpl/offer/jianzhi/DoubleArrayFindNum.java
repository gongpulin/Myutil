package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/7/18.
 */
public class DoubleArrayFindNum {
    public boolean find(int array[][], int target){
        boolean isFind = false;
        int cols = array.length; //数组行数
        int rows = array[0].length; //数组列数
        int i = 0;
        int j = rows-1;
        while(i<cols && j>=0){
            int value = array[i][j];
            if(value>target)
                j--;
            else if(value<target)
                i++;
            else{
                isFind = true;
                break;
            }
        }
        return isFind;
    }

    public boolean myfind(int array[][],int target){
        boolean isFind = false;
        int cols = array.length; //数组行数
        int rows = array[0].length; //数组列数
        int i =  0;
        return  isFind;
    }

    public static void main(String args[]){
        DoubleArrayFindNum daf = new DoubleArrayFindNum();
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(daf.find(array,1));

    }
}
