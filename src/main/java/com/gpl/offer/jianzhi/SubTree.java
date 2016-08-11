package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/10.
 */
public class SubTree {
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


    public boolean hasSubtree(Node root1, Node root2) {
        boolean hasSubTree = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                hasSubTree = treeEqual(root1,root2);
            }
            if(!hasSubTree){
                hasSubTree = hasSubtree(root1.left, root2);
            }
            if(!hasSubTree){
                hasSubTree = hasSubtree(root1.right, root2);
            }
        }

        return hasSubTree;
    }

    private boolean treeEqual(Node root1, Node root2) {

        if(root2 == null) return true;
        if(root1 == null) return false; //这两个if的顺序不能变！！！！！！！！！！！！！！！！！

        if(root1.val != root2.val) return false;
        return treeEqual(root1.left, root2.left) && treeEqual(root1.right, root2.right);
    }



    public static void main(String args[]){
        SubTree st = new SubTree();
        Node root1 = new Node(1);
        Node node1 = new Node(11);
        Node node2 = new Node(21);
        root1.setLeft(node1);
        root1.setRight(node2);
        Node node3 = new Node(31);
        Node node4 = new Node(32);
        node1.setLeft(node3);
        node2.setLeft(node4);

        Node root2 = new Node(1);
        Node node11 = new Node(11);
        Node node21 = new Node(21);
        root2.setLeft(node11);
        root2.setRight(node21);

        System.out.println(st.hasSubtree(root1,root2));

    }



}
