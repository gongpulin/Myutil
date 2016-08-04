package com.gpl.offer.jianzhi;

import java.util.Stack;

/**
 * Created by gpl on 2016/8/3.
 */
public class Stack2Queue {

    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    public Stack2Queue(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void inQueue(int i){
        stack1.push(i);
    }
    public int outQueue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        if(stack2.isEmpty()){
            try{
                throw new Exception("empty queue");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        Stack2Queue sq = new Stack2Queue();
        sq.inQueue(1);
        sq.inQueue(2);
        sq.inQueue(3);
        System.out.println(sq.outQueue());
        System.out.println(sq.outQueue());
        System.out.println("stack1大小："+sq.stack1.size());
        System.out.println("stack2大小："+sq.stack2.size());
        sq.inQueue(4);
        System.out.println("stack1大小："+sq.stack1.size());
        System.out.println(sq.outQueue());
        System.out.println(sq.outQueue());
    }

}
