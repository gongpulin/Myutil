package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/9.
 */
public class ReOrderArrayOddEvenOdd {    //调整数组顺序使奇数位于偶数前面

    public int[] reOrderArray(int[] array){   //允许改变相对位置
        if(array == null || array.length == 0)
            return null;
        int begin = 0;
        int end = array.length-1;
        while(begin < end){
            while(!isEven(array[begin]) && begin<end)
                begin++;
            while(isEven(array[end]) && begin<end)
                end--;
            if(begin < end){
                swap(array,begin,end);
            }
        }
        return array;

    }

    private boolean isEven(int n){   //判断是否是偶数
        if((n & 0x1 )==0)
            return true;
        return false;
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        ReOrderArrayOddEvenOdd roaoe = new ReOrderArrayOddEvenOdd();
        int a[] = {1,2,3,4,5,6,7,8,9};
        int array[] = roaoe.reOrderArray2(a);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }


    public int[] reOrderArray2(int[] array){    //不允许改变相对位置
        if(array == null || array.length ==0)
            return null;
        int j;
        for(int i=1;i<array.length;i++){
            int temp = array[i];
            if(!isEven(array[i])){
                for(j=i-1;j>=0 && isEven(array[j]);j--){
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
        return array;
    }

}
