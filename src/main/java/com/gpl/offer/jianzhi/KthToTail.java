package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/9.
 */
public class KthToTail {     //链表中的倒数第k个节点

    public LinkNode findk(LinkNode head,int k){
        if(head == null || k < 0)
            return null;
        LinkNode front  = head;
        LinkNode behind = null;
        for(int i=0;i<k-1;i++){
            if(front.next!=null)
                front = front.next;
            else
                return null;
        }
        behind = head;
        while(front.next!=null){
            front = front.next;
            behind = behind.next;
        }
        return behind;

    }

    public static void main(String[] args){
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
        KthToTail ktt = new KthToTail();
        LinkNode nodeK = ktt.findk(head,6);
        System.out.println(nodeK.val);




    }
}

class LinkNode{
    int val;
    LinkNode next = null;
    public LinkNode(int val){
        this.val = val;
    }
    public void setNext(LinkNode next) {
        this.next = next;
    }
}
