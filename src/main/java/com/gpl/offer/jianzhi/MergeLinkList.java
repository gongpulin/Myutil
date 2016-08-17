package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/8/10.
 */
public class MergeLinkList {
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

    public LinkNode mergeLinkList(LinkNode listHead1,LinkNode listHead2){
        if(listHead1 == null)
            return listHead2;
        if(listHead2 == null)
            return listHead1;
        LinkNode listHead = null;
        if(listHead1.val < listHead2.val){
            listHead = listHead1;
            listHead.next = mergeLinkList(listHead1.next,listHead2);
        }else{
            listHead = listHead2;
            listHead.next = mergeLinkList(listHead1,listHead2.next);
        }
        return listHead;
    }

    public static void main(String[] args){
        LinkNode head1 = new LinkNode(1);
        LinkNode h1 = new LinkNode(2);
        LinkNode h2 = new LinkNode(3);
        LinkNode h3 = new LinkNode(4);
        LinkNode h4 = new LinkNode(5);
        LinkNode h5 = new LinkNode(69);
        head1.setNext(h1);
        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);
        h4.setNext(h5);
        h5.setNext(null);
        LinkNode head2 = new LinkNode(11);
        LinkNode h11 = new LinkNode(22);
        LinkNode h21 = new LinkNode(33);
        LinkNode h31 = new LinkNode(44);
        LinkNode h41 = new LinkNode(55);
        LinkNode h51 = new LinkNode(66);
        head2.setNext(h11);
        h11.setNext(h21);
        h21.setNext(h31);
        h31.setNext(h41);
        h41.setNext(h51);
        h51.setNext(null);

        MergeLinkList mll = new MergeLinkList();
        LinkNode head = mll.mergeLinkList(head1,head2);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}
