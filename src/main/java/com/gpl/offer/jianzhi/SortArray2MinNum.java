package com.gpl.offer.jianzhi;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gpl on 2016/9/9.
 */
public class SortArray2MinNum {  //把数组排成最小的数

    public String getMinNum(int[] array){
        if(array == null || array.length == 0)
            return "";
        String strs[] = new String[array.length];
        for(int i=0;i<array.length;i++)
            strs[i] = array[i]+"";
        Arrays.sort(strs,new Comparator<String>(){
            public int compare(String s1,String s2){
                return (s1+s2).compareTo(s2+s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str:strs)
            sb.append(str);
        return sb.toString();
//        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args){
        SortArray2MinNum samn = new SortArray2MinNum();
        int array[] = {1,11,12,21,13,31};
        int array2[] ={2,21,221};
        System.out.println(Integer.parseInt(samn.getMinNum(array2)));
    }


}
