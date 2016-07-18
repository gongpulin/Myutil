package com.gpl.sort;

public class Insertsort {

	public static void main(String[] args) {
		int[] a={1,5,9,8,6,2};
		int[] b=insertsort(a);
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+" ");
			
		}
	}
	public static int[] insertsort(int array[]){
		int i,j,temp;
		for(i=1;i<array.length;i++){
			temp=array[i];
			for(j=i-1;j>=0;j--){
				if(array[j]>temp){
					array[j+1]=array[j];
				}
				else
					break;
			}
			array[j+1]=temp;
		}
		return array;
	}
}
