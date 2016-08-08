package com.gpl.offer.jianzhi;

import java.util.Stack;

/**
 * Created by gpl on 2016/8/6.
 */
public class MinStack {
    Stack<Integer> data = null;
    Stack<Integer> assist = null;

    public MinStack(){
        data = new Stack<Integer>();
        assist = new Stack<Integer>();
    }

    public void push(int node) {
        data.push(node);
        if(assist.size() == 0 || node < assist.peek()){
            assist.push(node);
        }else{
            assist.push(assist.peek());
        }
    }

    public void pop() {
        if(data.size() > 0 && assist.size() >0){
            data.pop();
            assist.pop();
        }
    }

    public int top() {
        if(data.size() > 0){
            return data.peek();
        }
        return -1;
    }

    public int min() {
        if(data.size() >0 && assist.size() > 0){
            return assist.peek();
        }
        return -1;
    }




}
