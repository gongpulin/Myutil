package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/8.
 */
public class MinNumberInRotatedArray {
    public int search(int[] array){
        if(array == null || array.length <= 0)
            return 0;
        int low = 0;
        int high = array.length-1;
        int mid = low;
        while(array[low] >= array[high]){
            if(high - low == 1)   //只有两个元素
                return array[high];

            mid = (low + high)/2;
            if(array[low] == array[high] && array[mid] == array[high]) //low、mid和high位置的元素都相同
                return orderSearch(array,low,high);

            if(array[mid] >= array[low])    //如果中间位置的值大于array[low]的值，说明最小值在a[mid]的右边
                low = mid;
            else if(array[mid] <= array[high])
                high = mid;
        }
        return array[mid];
    }
    private int orderSearch(int[] array,int low,int high){
        int min = array[low];
        for(int i=low+1;i<=high;i++){
            if(min>array[i])
                min = array[i];
        }
        return min;
    }

    public static void main(String[] args){
        MinNumberInRotatedArray mnira = new MinNumberInRotatedArray();
        int a[] = {4,5,6,7,2,3};
        int b = mnira.search(a);
        System.out.println("最小元素："+b);

    }

}
