package com.code.algorithm.sortion.list;

public class LinkedList<E> {

    private Node<E> node = new Node<E>();
    private Node<E> tail=null;
    private int size = 0;

    public class Node<T> {
        public T data;
        public Node<T> next;
        public Node() {
        }
        public Node(T data) {
            this.data=data;
            this.next=null;
        }
    }

    public E add(E e) {
        if (node.data==null) {
            node.data = e;
            tail = node;
            size++;
            return e;
        }

        tail.next = new Node<E>(e);
        tail = tail.next;
        size++;
        return e;
    }

    public E get(int index) throws RuntimeException {
        if (index<0||index>=size) {
            throw new RuntimeException();
        }
        int i = 0;
        Node<E> head = node;
        do {
            if (index==i) {
                return head.data;
            } else {
                i++;
                head=head.next;
            }
        } while (head.next!=null);
        return head.data;
    }
    public E update(int index, E e) throws RuntimeException {
        if (index<0||index>=size) {
            throw new RuntimeException();
        }
        int i = 0;
        Node<E> head = node;
        do {
            if (index==i) {
                head.data = e;
                return head.data;
            } else {
                i++;
                head=head.next;
            }
        } while (head.next!=null);
        head.data = e;
        return head.data;
    }

    public E remove(int index) {
        if (index<0||index>=size) {
            throw new RuntimeException();
        }
        int i = 0;
        Node<E> head = node;
        Node<E> before = null;
        Node<E> after = null;
        do {
            if (index==i) {
                if (index==0) {
                   before = node;
                   node = head.next;
                   size--;
                   return node.data;
                }
                after = head.next;
                before.next = after;
                size--;
                return head.data;
            } else {
                i++;
                before = head;
                head=head.next;
            }
        } while (head.next!=null);
        before.next = null;
        size--;
        return head.data;
    }

    public void printAll() {
        Node<E> head = node;
        do {
            System.out.print(head.data + "\t");
        } while ((head = head.next)!=null);
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        System.out.println(list.add("hello"));
        System.out.println(list.add("world"));
        System.out.println(list.add("world2"));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.printAll();
        list.remove(0);
        list.printAll();
        list.update(1, "foo");
        list.printAll();
    }
}
