package com.gpl.offer;

public class Transform {
	public String trans3(String s, int n) {
        // write code here
		StringBuilder sb=new StringBuilder();
		s=s.trim();
        String[] words=s.split(" ");
        for(int i=words.length-1;i>=0;i--){
        	String word=words[i];
        	for(int j=0;j<word.length();j++){
        		String a=word.substring(j, j+1);
        		if(a.equals(a.toLowerCase()))
        			sb.append(a.toUpperCase());
        		else if(a.equals(a.toUpperCase()))
        			sb.append(a.toLowerCase());
        	}
        	if(i!=0)
        		sb.append(" ");
        }
        return sb.toString();
    }
	
	
	public String trans(String s, int n) {
        // write code here
		//s=s.trim();
		String str="";
        String[] words=s.split(" ");
        int t=0;
        for(int i=words.length-1;i>=0;i--){
        	String word=words[i];
        	for(int j=0;j<word.length();j++){
        		String a=word.substring(j, j+1);
        		if(a.equals(a.toLowerCase()))
        			str+=(a.toUpperCase());
        		else if(a.equals(a.toUpperCase()))
        			str+=(a.toLowerCase());
        	}
        	if(i!=0)
        		str+=" ";
        }
        return str;
    }
	
	
	public String trans1(String s, int n) {
		StringBuilder sb=new StringBuilder();
		for(int i=n-1;i>=0;i--){
			String a=s.substring(i, i+1);
			if(a.equals(a.toLowerCase()))
    			sb.append(a.toUpperCase());
    		else if(a.equals(a.toUpperCase()))
    			sb.append(a.toLowerCase());
    		else if(a.equals(" "))
    			sb.append(" ");
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transform tf=new Transform();
		String abc=tf.trans3("This is a sample",16);
		System.out.println(abc);
	}

}
