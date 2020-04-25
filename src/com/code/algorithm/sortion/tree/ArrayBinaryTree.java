package com.code.algorithm.sortion.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayBinaryTree<E> {

    private Node<E> top;

    public ArrayBinaryTree() {
        
    }
    public static class Node<T> {
        private T data;
        private Node<T> lnode;
        private Node<T> rnode;
        private Integer depth = 4;

        public Node() {
            super();
        }
        public Node(T data) {
            super();
            this.data = data;
        }
        public T getData() {
            return data;
        }
        public Node<T> setData(T data) {
            this.data = data;
            return this;
        }
        public Node<T> getLnode() {
//            lnode = new Nod
            return lnode;
        }
        public Node<T> setLnode(Node<T> lnode) {
            this.lnode = lnode;
            return this;
            
        }
        public Node<T> setLdata(T ldata) {
            this.lnode = new Node<T>(ldata);
            return this;
            
        }
        public Node<T> getRnode() {
            return rnode;
        }
        public Node<T> setRnode(Node<T> rnode) {
            this.rnode = rnode;
            return this;
        }
        public Node<T> setRdata(T rdata) {
            this.rnode = new Node<T>(rdata);
            return this;
        }

        public Integer getDepth() {
            return depth;
        }
        public void setDepth(Integer depth) {
            this.depth = depth;
        }

        public String preOrderTraverse() {

            StringBuilder sb = new StringBuilder();
            sb.append(this.getData()).append(", ");
            if (this.getLnode()!=null) {
                sb.append(this.getLnode().preOrderTraverse());
            }
            if (this.getRnode()!=null) {
                sb.append(this.getRnode().preOrderTraverse());
            }
            return sb.toString();
        }

        public String postOrderTraverse() {
            StringBuilder sb = new StringBuilder();
            if (this.getLnode()!=null) {
                sb.append(this.getLnode().postOrderTraverse());
            }
            if (this.getRnode()!=null) {
                sb.append(this.getRnode().postOrderTraverse());
            }
            sb.append(this.getData()).append(", ");
            return sb.toString();
        }
        public String inOrderTraverse() {
            StringBuilder sb = new StringBuilder();
            if (this.getLnode()!=null) {
                sb.append(this.getLnode().inOrderTraverse());
            }
            sb.append(this.getData()).append(", ");
            if (this.getRnode()!=null) {
                sb.append(this.getRnode().inOrderTraverse());
            }
            return sb.toString();
        }

        public String gradualTraverse() {
            List<ArrayList<T>> matrix = new ArrayList<ArrayList<T>>();
            gradualTraverse(matrix, this, 0);
            return Arrays.deepToString(matrix.toArray());
        }

        private void gradualTraverse(List<ArrayList<T>> matrix, Node<T> node, Integer index) {
            if (node==null) {
                return;
            }
            ArrayList<T> listInIndex = null;
            if (node.getData()!=null) {
                if (index>=matrix.size()) {
                    listInIndex = new ArrayList<T>();
                    matrix.add(listInIndex);
                } else {
                    listInIndex = matrix.get(index);
                }
                listInIndex.add(node.getData());
            }
            index++;
            gradualTraverse(matrix, node.getLnode(), index);
            gradualTraverse(matrix, node.getRnode(), index);
        }

        private void transform2Array(List<ArrayList<T>> matrix, Node<T> node, Integer index) {
            if (index>=depth) {
                return;
            }
            if (node==null) {
                node = new Node<T>();
            }
            ArrayList<T> listInIndex = null;
            if (index>=matrix.size()) {
                listInIndex = new ArrayList<T>();
                matrix.add(listInIndex);
            } else {
                listInIndex = matrix.get(index);
            }
            listInIndex.add(node.getData());

            index++;
            transform2Array(matrix, node.getLnode(), index);
            transform2Array(matrix, node.getRnode(), index);
        }

        public List<T> transform2Array() {
            List<ArrayList<T>> matrix = new ArrayList<ArrayList<T>>();
            transform2Array(matrix, this, 0);
            List<T> result = new ArrayList<T>();
            for (int i = 0; i < matrix.size(); i++) {
                result.addAll(matrix.get(i));
            }
            return result;
        }

        public Node<T> transform2SortionTree() {
            
            
            
            return null;
        }
    }

    public Node<E> getTop() {
        return top;
    }
    public Node<E> setTop(Node<E> top) {
        this.top = top;
        return this.top;
    }
    public Node<E> setTop(E topElement) {
        this.top = new Node<E>(topElement);
        return this.top;
    }

    public Node<E> newNode() {
        Node<E> newNode = new Node<E>();
        return newNode;
    }

    public String preOrderTraverse() {
        return getTop().preOrderTraverse();
    }
    public String postOrderTraverse() {
        return getTop().postOrderTraverse();
    }
    public String inOrderTraverse() {
        return getTop().inOrderTraverse();
    }
    public String gradualTraverse() {
        return getTop().gradualTraverse();
    }

    public List<E> transform2Array() {

        return getTop().transform2Array();
    }

    public Node<E> transform2Node(List<E> array) {
        
        return transform2Node(array, array.size(), 0);
    }

    public Node<E> transform2SortionTree() {
        return getTop().transform2SortionTree();
    }

    public Node<E> transform2SortionTree(List<E> array) {
        Node<E> newNode = new Node<E>();
        for (int i = 0; i < array.size(); i++) {
            insert(newNode, array.get(i));
        }
        return newNode;
    }

    private void insert(Node<E> node, E data) {

        if (node!=null&&node.getData()==null) {
            node.setData(data);
            return;
        } else if (compare(node.getData(), data)) {
            if (node.getLnode()==null||node.getLnode().getData()==null) {
                node.setLnode(newNode());
//                return;
            }
            insert(node.getLnode(), data);
        } else {
            if (node.getRnode()==null||node.getRnode().getData()==null) {
                node.setRnode(newNode());
//                return;
            }
            insert(node.getRnode(), data);
        }
    }
    private boolean compare(E data, E data2) {
        Integer num = 0;
        if (data instanceof Integer && data2 instanceof Integer) {
            num = (Integer)data - (Integer)data2;
        }
        return num>=0?true:false;
    }
    private Node<E> transform2Node(List<E> array, int size, int index) {
        if (index>=size) {
            return null;
        }
        Node<E> node = new Node<E>();
        node.setData(array.get(index))
            .setLnode(transform2Node(array, size, 2*index+1))
            .setRnode(transform2Node(array, size, 2*index+2));
        return node;
    }
    public static void main(String[] args) {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<Integer>();
        tree.setTop(5)
            .setLnode(tree.newNode()
                         .setData(6)
                         .setLdata(7))
            .setRdata(8);
        System.out.println(tree.preOrderTraverse());
        System.out.println(tree.postOrderTraverse());
        System.out.println(tree.inOrderTraverse());
        System.out.println(tree.gradualTraverse());

        tree.setTop(5)
        .setLnode(tree.newNode()
                     .setData(6)
                     .setLdata(7)
                     .setRnode(
                             tree.newNode()
                                 .setData(9)
                                 .setLdata(11)
                                 .setRdata(13)
                                 )
                     )
        .setRnode(tree.newNode()
                .setData(15)
                .setLdata(21)
                .setRnode(
                        tree.newNode()
                            .setData(33)
                            .setLdata(31)
                            .setRdata(17)
                            )
                );
        tree.getTop().setDepth(4);
        System.out.println(tree.gradualTraverse());
        System.out.println(tree.transform2Array());
        System.out.println(tree.transform2Node(tree.transform2Array()).transform2Array());
        Integer[] list = {5, 3, 6, 4, 8, 12,-1, 4, -9, 22, 21, 13, 19};
        List<Integer> asList = Arrays.asList(list);
        System.out.println(tree.transform2SortionTree(asList).inOrderTraverse());
        System.out.println(tree.transform2SortionTree(tree.transform2Array()).inOrderTraverse());
    }

}
