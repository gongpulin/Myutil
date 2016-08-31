package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/30.
 */
public class ArraySum {     //连续子数组的最大和

    public int findarray(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int sum = 0;
        int curSum = 0;
        for(int i=0;i<array.length;i++){
            if(curSum<=0)
                curSum = array[i];
            else
                curSum += array[i];
            if(curSum > sum)
                sum = curSum;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
//        int[] array = {1,3,5,-6,9,10,-11,20};
        ArraySum as = new ArraySum();
        System.out.println(as.findarray(array));

    }
}
