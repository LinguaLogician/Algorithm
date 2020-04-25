package com.code.algorithm.sortion.stake;

public class Stake {

    private String[] stk = new String[20];

    private int size = 0;
    public Stake() {
        
    }
    
    public boolean push(String element) {

        if (size>=20) {
            throw new RuntimeException("over the capacity");
        }
        stk[size++]=element;
        return true;
    }

    public String pop() {
        if (size==0) {
            throw new RuntimeException("the queue is empty");
        }
        String top = stk[--size];
        stk[size] = null;
        return top;
    }
    
    public String peek() {
        if (size==0) {
            throw new RuntimeException();
        }
        return stk[size-1];
        
    }
    public static void main(String[] args) {
        Stake queue = new Stake();
        queue.push("hello");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        queue.push("world");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        
        
        
        
    }
}
