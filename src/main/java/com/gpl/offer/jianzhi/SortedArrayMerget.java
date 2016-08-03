package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/7/19.
 */
public class SortedArrayMerget {

    public int[] sortedArrayMerge(int[] a,int[] b){
        int aLen = a.length;
        int bLen = b.length;
        int cLen = aLen+bLen;
        int[] c = new int[cLen];
        int i = aLen - 1;
        int j = bLen - 1;
        while(i>=0&&j>=0){
            if(a[i]>b[j])
                c[--cLen] = a[i--];
            else
                c[--cLen] = b[j--];
        }
        while(i>=0){
            c[--cLen]  = a[i--];
        }
        while(j>=0){
            c[--cLen] = b[j--];
        }
        return c;
    }

    public int[] sortedArrayMerge1(int[] a,int[] b){
        int aLen = a.length;
        int bLen = b.length;
        int[] c = new int[aLen+bLen];
        System.arraycopy(a,0,c,0,aLen);
        System.arraycopy(b,0,c,aLen,bLen);
        return c;

    }


    public static void main(String[] args){
        int[] a = {1,3,5,9};
        int[] b = {2,4,6,8,10};
        SortedArrayMerget sam = new SortedArrayMerget();
        int[] c = sam.sortedArrayMerge1(a,b);
        for(int i=0;i<c.length;i++)
            System.out.println(c[i]+" ");


    }
}
