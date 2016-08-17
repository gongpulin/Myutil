package com.gpl.offer.jianzhi;

import java.util.HashMap;

/**
 * Created by gpl on 2016/8/12.
 */
public class FirstNotRepeatingCharOdString {   //第一个只出现一次的字符

    public int getIndex(String str){
        if(str == null || str.length() == 0)
            return -1;
        char[] chs = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char ch:chs){
            if(map.get(ch) != null)
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }
        for(char k:map.keySet()){
            System.out.println("k:"+k+" "+"value:"+map.get(k));
        }
        for(int i=0;i<chs.length;i++){
            if(map.get(chs[i]) == 1)
                return i;
        }

        return -1;
    }


    public static void main(String[] args){
        FirstNotRepeatingCharOdString fnrco = new FirstNotRepeatingCharOdString();
        String s = "aabqbccdeeff";
        System.out.println(fnrco.getIndex(s));
    }

}
