package com.gpl.offer.jianzhi;

/**
 * Created by gpl on 2016/9/1.
 */
public class FirstCommonListNode {
    static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode findFirstCommonListNode(ListNode head1,ListNode head2){
        int list1 = 0;
        int list2 = 0;
        ListNode tempNode = head1;
        while(tempNode != null){
            list1++;
            tempNode = tempNode.next;
        }
        tempNode = head2;
        while(tempNode != null){
            list2++;
            tempNode = tempNode.next;
        }
        int listDif = list1 - list2;
        ListNode longListhead = null;
        ListNode shortListhead = null;
        if(listDif >= 0){
            longListhead = head1;
            shortListhead = head2;
        }else{
            longListhead = head2;
            shortListhead = head1;
            listDif = -listDif;
        }
        for(int i=0;i<listDif;i++){
            longListhead = longListhead.next;
        }

//        while(shortListhead != null && longListhead != null){
//            if(shortListhead.val == longListhead.val)
//                return longListhead;
//        }
//        return null;
        while(shortListhead != null && longListhead != null && shortListhead.val != longListhead.val){
            shortListhead = shortListhead.next;
            longListhead = longListhead.next;
        }
        return longListhead;
    }

    public static void main(String[] args){
        ListNode pHead1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(7);
        pHead1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode pHead2 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        pHead2.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = FirstCommonListNode.findFirstCommonListNode(pHead1,pHead2);
        System.out.println(result.val);
    }
}
