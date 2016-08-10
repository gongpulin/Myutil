package com.gpl.offer.jianzhi;

import java.util.Stack;

/**
 * Created by gpl on 2016/8/9.
 */
public class PrintReverseLinkList {
    public static class LinkNode{
        int val;
        LinkNode next = null;
        public LinkNode(int val){
            this.val = val;
        }
        public void setNext(LinkNode next) {
            this.next = next;
        }
    }

    public void printreverseList(LinkNode head){
        if(head == null)
            return;
        LinkNode reverseHead = null;    //反转之后链表的头结点
        LinkNode curNode = head;
        LinkNode preNode = null;         //遍历到的结点的前一个结点，该节点的作用让当前遍历到的指向其前一个结点
        while(curNode!=null){
            LinkNode nextNode = curNode.next;
            if(nextNode == null)
                reverseHead = curNode;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        LinkNode node = reverseHead;
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }


    }

    public static void main(String[] args){
        PrintReverseLinkList prl = new PrintReverseLinkList();
        LinkNode head = new LinkNode(1);
        LinkNode h1 = new LinkNode(2);
        LinkNode h2 = new LinkNode(3);
        LinkNode h3 = new LinkNode(4);
        LinkNode h4 = new LinkNode(5);
        LinkNode h5 = new LinkNode(6);
        head.setNext(h1);
        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);
        h4.setNext(h5);
        h5.setNext(null);
        prl.printreverseList(head);

    }

    public void printreverseList1(LinkNode head){
        if(head == null)
            return;
        Stack<LinkNode> stack = new Stack<LinkNode>();
        LinkNode node  = head;
        while(node!=null){
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().val);
        }
    }

}



