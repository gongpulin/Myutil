package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/9/5.
 */
public class IntrgerNumberof1from1toN {   //0-N   整数中1的个数

    public int getNumerof1(int n){
        if(n == 0)
            return 0;
        if(n <= 9)
            return 1;
        int result = 0;
        for(int i=1;i<=n;i++){
            result += numberof1(i);
        }
        return result;
    }
    private int numberof1(int number){  //判断某个数中1的个数
        int result = 0;
        while(number > 0){
            if(number%10 == 1)
                result++;
            number = number/10;
        }
        return result;
    }

    public static void main(String[] args){
        IntrgerNumberof1from1toN in = new IntrgerNumberof1from1toN();
        System.out.println(in.getNumerof1(11));
    }

}
