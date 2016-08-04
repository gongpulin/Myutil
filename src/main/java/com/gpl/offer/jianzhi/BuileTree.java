package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/3.
 */
public class BuileTree {
    public TreeNode reConstrucBinaryTree(int[] pre,int[] in){
        int len_pre = pre.length;
        int len_in = in.length;
        if(pre == null||in == null||len_pre != len_pre)
            return null;
        TreeNode node = reConstruct(pre,0,len_pre-1,in,0,len_in-1);
        return node;
    }

    public TreeNode reConstruct(int[] pre,int begin_pre,int end_pre,int[] in,int begin_in,int end_in){
        if(begin_pre > end_pre || begin_in > end_in)
            return null;
        TreeNode root = new TreeNode(pre[begin_pre]);
        for(int i=begin_in;i<=end_in;i++){
            if(root.val == in[i]){
                int num = i-begin_in;
                root.left = reConstruct(pre,begin_pre+1,begin_pre+num,in,begin_in,i-1);
                root.right = reConstruct(pre,begin_pre+num+1,end_pre,in,i+1,end_in);
            }
        }
        return root;
    }

    public static void main(String args[]){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BuileTree bt = new BuileTree();
        TreeNode root = bt.reConstrucBinaryTree(pre,in);
        bt.TraverseTree_in(root);
    }
    public void TraverseTree_pre(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        TraverseTree_pre(root.left);
        TraverseTree_pre(root.right);
    }
    public void TraverseTree_in(TreeNode root){
        if(root ==null)
            return;
        TraverseTree_in(root.left);
        System.out.println(root.val);
        TraverseTree_in(root.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int i){
        val = i;
    }
}
