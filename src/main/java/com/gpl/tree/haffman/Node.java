package com.gpl.tree.haffman;

public class Node implements Comparable<Node>{
	public Node left;
	public Node right;
	public String val;
	public float freq;
	public Node(String val,float freq){
		this.val=val;
		this.freq=freq;
	}
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.freq>o.freq){
			return 1;
		}
		if(this.freq<o.freq){
			return -1;
		}
		return -1;
	}

}
