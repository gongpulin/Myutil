package com.gpl.sort;

public class Bubblesort {
	
	public static void main(String[] args) {
		int[] a={1,5,9,8,6,2};
		int[] b=bubblesort(a);
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+" ");
		}
		
	}
	public static int[] bubblesort(int[] array){
		if(array==null)
			return null;
		int temp;
		for(int i=1;i<array.length;i++){
			for(int j=0;j<array.length-i;j++){
				if(array[j]>array[j+1]){
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
}
