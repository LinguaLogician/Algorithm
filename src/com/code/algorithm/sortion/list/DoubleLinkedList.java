package com.code.algorithm.sortion.list;

public class DoubleLinkedList<E> {

    private Node<E> node;
    private Node<E> head;
    private Node<E> foot;
    private int size = 0;

    public DoubleLinkedList() {
        
    }

    public class Node<T> {
        public T data;
        public Node<T> last;
        public Node<T> next;
        public Node() {
        }
        public Node(T data) {
            this.data=data;
            this.last=null;
            this.next=null;
        }
    }

    public E add(E e) {
        if (head!=null) {
            Node<E> head0 = head;
            head.next = new Node<E>(e);
            head = head.next;
            head.last = head0;
        } else {
            node = new Node<E>(e);
            head = node;
            foot = node;
        }
        size++;
        return e;
    }

    public E get(int index) throws RuntimeException {
        if (index<0||index>=size) {
            throw new RuntimeException();
        }
        int i = 0;
        Node<E> head0 = foot;
        do {
            if (index==i) {
                return head0.data;
            }
            i++;
            head0 = head0.next;
        } while (true);
    }
    public E update(int index, E e) throws RuntimeException {
        if (index<0||index>=size) {
            throw new RuntimeException();
        }
        int i = 0;
        Node<E> head0 = foot;
        do {
            if (index==i) {
                head0.data = e;
                return head0.data;
            } else {
                i++;
                head0=head0.next;
            }
        } while (true);
    }

    public E remove(int index) {
        if (index<0||index>=size) {
            throw new RuntimeException();
        }
        int i = 0;
        Node<E> head0 = foot;
        do {
            if (index==i) {
                Node<E> last0 = head0.last;
                Node<E> next0 = head0.next;
                if (last0!=null) {
                    last0.next = next0;
                } else {
                   foot = next0;
                }
                if (next0!=null) {
                    next0.last = last0;
                } else {
                    head = last0;
                }
                size--;
                return head0.data;
            }
            i++;
            head0=head0.next;
        } while (true);
    }

    public void printAll() {
        Node<E> head = foot;
        do {
            System.out.print(head.data + "\t");
        } while ((head = head.next)!=null);
        System.out.println();
    }

    public static void main(String[] args) {
        
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.add("hello");
        list.add("world");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.update(1, "foo"));
        System.out.println(list.get(1));
        System.out.println(list.remove(0));
        list.printAll();
    }
}
