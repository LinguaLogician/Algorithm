package com.code.algorithm.sortion.queue;

public class Queue {

    private String[] qu;
    private int top = -1;
    private int bottom = -1;
    private int size = 0;
    private int capacity = 0;

    public Queue(int capacity) {
        this.capacity = capacity;
        qu = new String[capacity];
    }

    public boolean offer(String element) {
        if (size>=20) {
            throw new RuntimeException("over the capacity");
        }
        if (bottom==-1) {
            bottom++;
            qu[++top] = element;
        } else if (top>=capacity-1 && bottom>0) {
            qu[0] = element;
            top = 0;
        } else {
            qu[++top] = element;
        }
        size++;
        return true;
    }

    public String poll() {
        if (size==0) {
            throw new RuntimeException("the queue is empty");
        }
        String result = qu[bottom];
        qu[bottom++] = null;
        if (bottom>capacity-1) {
            bottom = 0;
        }
        if (--size==0) {
            bottom=-1;
            top=-1;
        }
        return result;
    }

    public String peek() {
        
        
        return null;
    }

    public void printAll() {

        System.out.println(String.format("size: %d, top: %d, bottom: %d ", size, top, bottom));
        for (int i = 0; i < qu.length; i++) {
            System.out.print(qu[i] + "\t");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.offer("hello");
        queue.offer("world");
        queue.offer("foo");
        queue.printAll();
        System.out.println(queue.poll());
        queue.printAll();
        queue.offer("bar");
        System.out.println(queue.poll());
        queue.offer("bar");
        queue.printAll();
        System.out.println(queue.poll());
        queue.printAll();
        System.out.println(queue.poll());
        queue.printAll();
//        System.out.println(queue.poll());
    }
}
