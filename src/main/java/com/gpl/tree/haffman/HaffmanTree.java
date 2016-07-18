package com.gpl.tree.haffman;
import java.util.Stack;
import java.util.TreeSet;
/*
 * 在使用类似TreeSet等能取出一个元素并从集合中移除，此时不能使用     集合.size() 来获取集合大小，
 * 每移除一个集合大小就改变了，切记！
 * 
 */
//http://blog.csdn.net/hengwujun0903/article/details/12394339
public class HaffmanTree {
	private Node root=null;
	public TreeSet<Node> ts;
	public Node getRoot() {
		return root;
	}
	public HaffmanTree(){
		ts=new TreeSet<Node>();
	}
	public void BuildHaffmaTree(TreeSet<Node> ts){
		int size=ts.size();
		for(int i=1;i<size;i++){
			Node node1=ts.pollFirst();
			Node node2=ts.pollFirst();
			Node parentNode=new Node(node1.val+node2.val,node1.freq+node2.freq);
			System.out.println(parentNode.val+"  "+parentNode.freq);
			parentNode.left=node1;
			parentNode.right=node2;
			ts.add(parentNode);
			if(i==size-1){
				root=parentNode;
			}
		}
	}
	
	/*
	 * 前序遍历(根左右)  递归版
	 */
	public void preOrder(Node node){
		if(node!=null){
			System.out.println(node.val+" "+node.freq);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/*
	 * 中序遍历（左根右）
	 */
	public void middleOrder(Node node){
		if(node!=null){
			middleOrder(node.left);
			System.out.println(node.val+" "+node.freq);
			middleOrder(node.right);
		}
	}
	
	/*
	 * 后序遍历（左右根）
	 */
	public void posOrder(Node node){
		if(node!=null){
			posOrder(node.left);
			posOrder(node.right);
			System.out.println(node.val+" "+node.freq);
		}
	}
	
	//用数组实现栈
	//http://www.cnblogs.com/dyllove98/archive/2013/07/19/3201141.html
	/*
	 * 前序遍历：（非递归版）
	 */
	public void preOrderNoRec(Node root){
		if(root!=null){
			Stack<Node> stack=new Stack<Node>();
			Node temp=root.left;
			stack.push(root);
			System.out.println(root.val+" "+root.freq);
			while(!stack.isEmpty()||temp!=null){
				while(temp!=null){
					System.out.println(temp.val+" "+temp.freq);
					stack.push(temp);
					temp=temp.left;
				}
				temp=stack.pop();
				temp=temp.right;
			}
		}
		
	}
	public void middleOrderNoRec(Node root){
		if(root!=null){//http://www.cnblogs.com/javaexam2/archive/2011/07/25/2632905.html
			Stack<Node> stack=new Stack<Node>();
			stack.push(root);
			Node temp=root.left;
			while(!stack.isEmpty()||temp!=null){
				if(temp!=null){
					stack.push(temp);
					temp=temp.left;					
				}else{
					temp=stack.pop();
					System.out.println(temp.val+" "+temp.freq);
					temp=temp.right;
				}
				
			}
		}
	}
	
	//http://www.cnblogs.com/javaexam2/archive/2011/07/25/2632905.html
	public void posOrderNoRec(Node root){
		if(root!=null){
			Stack<Node> stack=new Stack<Node>();
			stack.push(root);
			Node prev=null;
			Node curr=null;
			while(!stack.isEmpty()){
				curr=stack.peek();
				if(prev==null||prev.left==curr||prev.right==curr){
					if(curr.left!=null){
						stack.push(curr.left);
					}else if(curr.right!=null){
						stack.push(curr.right);
					}
				}else if(curr.left==prev){
					if(curr.right!=null)
						stack.push(curr.right);
				}
				else{
					System.out.println(curr.val+" "+curr.freq);
					stack.pop();
				}
				prev=curr;
			}
		}
	}
	
	private void show(TreeSet<Node> ts){
		System.out.println("----------------1"+ts.size());
		for(int i=0;i<ts.size();i++){
			Node node=ts.first();
			System.out.println(node.val+" "+node.freq);
		}
		System.out.println("----------------2");
	}
	
	
	
	
	public static void main(String[] args) {
		HaffmanTree ht=new HaffmanTree();
		ht.ts.add(new Node("e",0.9f));
		ht.ts.add(new Node("b",0.6f));
		ht.ts.add(new Node("a",0.5f));
		ht.ts.add(new Node("f",0.4f));
		ht.ts.add(new Node("g",0.3f));
		System.out.println(ht.ts.size());
		ht.BuildHaffmaTree(ht.ts);
		System.out.println("gpl:"+ht.root.val+" "+ht.root.freq);
//		System.out.println("前序遍历：");
//		ht.preOrder(ht.root);
//		System.out.println("中序遍历：");
//		ht.middleOrder(ht.root);
//		System.out.println("后序遍历：");
//		ht.posOrder(ht.root);
//		System.out.println("前序遍历：");
//		ht.preOrderNoRec(ht.root);
//		System.out.println("中序遍历：");
//		ht.middleOrderNoRec(ht.root);
		System.out.println("后序遍历：");
		ht.posOrderNoRec(ht.root);
	}

}
