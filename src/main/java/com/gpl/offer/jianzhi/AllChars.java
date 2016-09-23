package com.gpl.offer.jianzhi;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gpl on 2016/9/9.
 */
public class AllChars {    //字符串的全排列

    public ArrayList<String> getAllChars(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str == null || str.length() == 0)
            return list;
        list = permutation(list,str.toCharArray(),0,str.length());
        Collections.sort(list);
        return list;

    }

    public ArrayList<String> permutation(ArrayList<String> list,char[] chs,int begin,int length){
        if(begin == length - 1){
            String s = String.valueOf(chs);
            if(!list.contains(s)){
                list.add(s);
            }
        }else{
            for(int i=begin;i<length;i++){
                if(i == begin || chs[i]!=chs[begin]){
                    swap(chs,begin,i);
                    permutation(list,chs,begin+1,length);
                    swap(chs,begin,i);
                }
            }
        }
        return list;
    }

    public void swap(char[] chs,int from,int to){
        char temp = chs[from];
        chs[from] = chs[to];
        chs[to] = temp;
    }

    public static void main(String[] args){
        AllChars ac = new AllChars();
        String str = "abc";
        ArrayList<String> list = ac.getAllChars(str);
        for(String s:list)
            System.out.println(s);
    }

}
