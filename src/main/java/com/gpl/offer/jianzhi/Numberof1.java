package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/8.
 */
public class Numberof1 {   //二进制中1的个数
    public int numberof1(int n){
        int sum = 0;
        while(n!=0){
            sum++;
            n=n&(n-1);
        }
        return sum;
    }
    public static void main(String[] args){
        Numberof1 nb = new Numberof1();
        System.out.println(nb.numberof1(9));
    }
}
