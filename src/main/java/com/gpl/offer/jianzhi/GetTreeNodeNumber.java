package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/11.
 */
public class GetTreeNodeNumber {
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


    public int getTreeNodeNum(Node root){
        if(root == null)
            return 0;
        return getTreeNodeNum(root.left)+getTreeNodeNum(root.right)+1;

    }

    public static int num = 0;
    public int pre(Node root){
        if(root!=null){
            num++;
            pre(root.left);
            pre(root.right);
        }
        return num;
    }

    public int getLeafNode(Node root){   //获取叶子节点个数
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return getLeafNode(root.left)+getLeafNode(root.right);
    }


    public static void main(String args[]) {
        Node root1 = new Node(1);
        Node node1 = new Node(11);
        Node node2 = new Node(21);
        root1.setLeft(node1);
        root1.setRight(node2);
        Node node3 = new Node(31);
        Node node4 = new Node(32);
        node1.setLeft(node3);
        node2.setLeft(node4);

        GetTreeNodeNumber gtn = new GetTreeNodeNumber();
        System.out.println(gtn.pre(root1));
        System.out.println(gtn.getTreeNodeNum(root1));
        System.out.println(gtn.getLeafNode(root1));


    }

}
