package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/4.
 */
public class Fibonacci {

    public int fibonacci(int n){
        if(n == 0)
            return 0;
        if(n ==1)
            return 1;
        int one = 0;
        int two = 1;
        int result = 0;
        for(int i=2;i<=n;i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibonacci(6));
        System.out.println(f.fi(6));

    }

    public int fi(int n){
        if(n == 0)
            return 0;
        else if(n ==1)
            return 1;
        else{
            return fi(n-1)+fi(n-2);
        }

    }

}
