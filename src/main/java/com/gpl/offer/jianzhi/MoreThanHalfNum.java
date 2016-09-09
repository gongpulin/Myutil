package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/9/9.
 */
public class MoreThanHalfNum {   //出现次数超过一半的数字


    public int getMoreThanHalfNum(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int times = 1;
        int result = array[0];
        for(int i=1;i<array.length;i++){
            if(times == 0){
                result = array[i];
                times = 1;
            }else if(result == array[i]){
                times++;
            }else{
                times--;
            }
        }
        if(checkIsMoreThanHalfNum(array,result))
            return result;
        else
            return 0;
    }

    public boolean checkIsMoreThanHalfNum(int[] array,int result){
        boolean isMoreThanHalfNum = false;
        int times = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] == result){
                times++;
            }
        }
        isMoreThanHalfNum = times*2 > array.length;
        return isMoreThanHalfNum;
    }


    public static void main(String[] args){
        MoreThanHalfNum mthn = new MoreThanHalfNum();
        int array[] = {1,1,1,2,3,41,1,1,1,2,2,2,1,1,1};
        System.out.println(mthn.getMoreThanHalfNum(array));
    }

}
