package com.gpl.offer.jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by gpl on 2016/9/5.
 */
public class LastKNumber {     //最小的K个数

    public ArrayList<Integer> getlastNumber(int[] array,int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length == 0 || k <= 0 || k >array.length)
            return list;
        for(int i=0;i<array.length;i++)
            list.add(array[i]);
        Collections.sort(list);
        if(k >= array.length)
            return list;
        while(list.size() > k)
            list.remove(k);
        return list;


    }

    public static void main(String[] args){
        int[] array = {1,3,5,7,9,2,4,6,10};
        LastKNumber ln = new LastKNumber();
        ArrayList list = ln.getlastNumber2(array,3);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));

    }

    public ArrayList<Integer> getlastNumber2(int[] array,int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length == 0 || k <= 0)
            return list;
        TreeSet<Integer> treeSet = new TreeSet();
        for(int i=0;i<array.length;i++){
            if(treeSet.size() < k){
                treeSet.add(array[i]);
            }else if(array[i] < treeSet.last()){
                treeSet.remove(treeSet.last());
                treeSet.add(array[i]);
            }
        }
        Iterator<Integer> iter = treeSet.iterator();
        while(iter.hasNext()){
            list.add(iter.next());
        }
        return list;
    }

}
