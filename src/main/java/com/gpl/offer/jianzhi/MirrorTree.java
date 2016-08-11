package com.gpl.offer.jianzhi;

import java.util.Stack;

/**
 * Created by gpl on 2016/8/11.
 */
public class MirrorTree {
    public static class Node{   //树的子结构
        int val;
        Node left;
        Node right;
        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(int val){
            this.val = val;
        }
    }

    public void mirrorTree(Node root){    //递归
        if(root == null ||(root.left ==null && root.right == null))
            return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left !=null){
            mirrorTree(root.left);
        }
        if(root.right != null){
            mirrorTree(root.right);
        }

    }

    public void mirrorTree1(Node root){    //非递归
        if(root == null ||(root.left ==null && root.right == null))
            return;
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while(!s.isEmpty()){
            Node node = s.pop();
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left!=null)
                s.push(node.left);
            if(node.right!=null)
                s.push(node.right);
        }
    }


    public void preOrder(Node root){  //前序遍历非递归
        if(root == null || (root.left == null && root.right == null))
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node node  = root;
        while(!stack.isEmpty()){
            while(node!=null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public void InOrder(Node root){
        if(root == null || (root.left == null && root.right == null))
            return;
        Stack<Node> stack = new Stack<Node>();
//        stack.push(root);
        Node node = root;
        while(!stack.isEmpty() || node != null){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.peek();
                System.out.println(node.val);
                stack.pop();
                node = node.right;
            }
        }
    }

    public void pre(Node root){     //前序遍历递归
        if(root != null){
            System.out.println(root.val);
            pre(root.left);
            pre(root.right);
        }
    }

    public static void main(String args[]) {
        MirrorTree mt = new MirrorTree();
        Node root1 = new Node(1);
        Node node1 = new Node(11);
        Node node2 = new Node(21);
        root1.setLeft(node1);
        root1.setRight(node2);
        Node node3 = new Node(31);
        Node node4 = new Node(32);
        node1.setLeft(node3);
        node2.setLeft(node4);
        mt.mirrorTree1(root1);
        mt.preOrder(root1);

    }

}
