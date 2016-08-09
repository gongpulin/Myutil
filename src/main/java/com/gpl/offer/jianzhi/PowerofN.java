package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/8.
 */
public class PowerofN {   //数的整数次方
    public double power(double base,int n){
        double result = 1;
        if(n == 0)
            return 1;
        else if(n >0){
            for(int i=0;i<n;i++)
                result =result*base;
            return result;
        }else{
            n = -n;
            for(int i=0;i<n;i++)
                result = result*base;
            return 1/result;
        }

    }

    public static void main(String[] args){
        double d = new PowerofN().power(-2,-3);
        System.out.println(d);
    }
}
