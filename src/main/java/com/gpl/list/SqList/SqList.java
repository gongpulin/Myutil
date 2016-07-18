package com.gpl.list.SqList;

public class SqList implements IList{
	
	private Object[] listElem;
	private int curLen;
	
	public SqList(int maxSize){
		listElem=new Object[maxSize];
		curLen=0;
	}
	@Override
	public void clear() {
		curLen=0;
	}

	@Override
	public boolean isEmpty() {
		return curLen==0;
	}

	@Override
	public int length() {
		return curLen;
	}


	public Object get(int i) throws Exception{
		if(i<0||i>curLen-1)
			throw new Exception("第"+i+"个元素不存在");
		return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		if(curLen==listElem.length)
			throw new Exception("顺序表已满");
		if(i<0||i>curLen)
			throw new Exception("插入位置不合法");
		for(int j=curLen;j>i;j--)
			listElem[j]=listElem[j-1];
		listElem[i]=x;
		curLen++;
	}

	@Override
	public void remove(int i) throws Exception {
		if(i<0||i>curLen-1)
			throw new Exception("删除位置不合法");
		for(int j=i;j<curLen-1;j++)
			listElem[j]=listElem[j+1];
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	
}
