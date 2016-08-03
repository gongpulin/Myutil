package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/7/19.
 */
public class ReplaceSpace {

    public String replaceSpace1(String str){
        int len = str.length();
        if(str ==null || len == 0)
            return null;
        int spaceNum = 0;
        for(int i=0;i<len;i++){
            if(str.charAt(i) == ' ')
                spaceNum++;
        }
        char[] chars = new char[len+spaceNum*2];
        for(int i=0,j=0;i<len;i++){
            if(str.charAt(i)==' '){
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            }else{
                chars[j++] = str.charAt(i);
            }
        }
        return new String(chars);
    }

    public String replaceSpace2(String str){
        int len = str.length();
        if(len == 0 || str == null)
            return null;
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<len;i++){
            if(str.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ReplaceSpace rs =new ReplaceSpace();
        System.out.println(rs.replaceSpace1("I am good boy"));
    }
}
