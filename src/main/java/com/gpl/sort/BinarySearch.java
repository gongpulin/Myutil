package com.gpl.sort;

/**
 * Created by gpl on 2016/8/10.
 */
public class BinarySearch {    //二分查找

    public int binarySearch(int[] array,int n){
        if(array == null || array.length == 0)
            return -1;
        int low = 0;
        int high = array.length - 1;
        while(low<=high){
            int mid = (low + high)/2;
            if(array[mid]>n)
                high = mid-1;
            else if(array[mid]<n)
                low = mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        BinarySearch bs = new BinarySearch();
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println("下标为:"+bs.binarySearch(a,6));
    }
}
