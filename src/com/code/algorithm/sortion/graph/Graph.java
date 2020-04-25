package com.code.algorithm.sortion.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<V, E> {

    List<List<E>> matrix;

    List<V> vertexs; 
    Integer vertexSize = 0;

    public Graph() {
        matrix = new ArrayList<List<E>>();
        vertexs = new ArrayList<V>();
    }
    
    public Graph(V vertex) {
        if (vertex==null) {
            return;
        }
        matrix = new ArrayList<List<E>>();
        vertexs = new ArrayList<V>();
        List<E> init = new ArrayList<E>();
        init.add(null);
//        init.add(t);
        vertexs.add(vertex);
        matrix.add(init);
        vertexSize++;
    }

    public void addVertex(E t, Integer... elements) {
        if (matrix.get(0)==null) {
            return;
        }
    }

    public void addVertex(Point toOrFrom, Integer linkIndex, V vertex, E edge) {
        if (matrix.size()<=linkIndex) {
            return;
        }
        for (List<E> list : matrix) {
            list.add(null);
        }
        vertexs.add(vertex);
        List<E> edgeList = new ArrayList<E>();
        for (int i = 0; i < matrix.size()+1; i++) {
            edgeList.add(null);
        }
        if (!Point.FROM.equals(toOrFrom)) {
            edgeList.set(linkIndex, edge);
        }
        matrix.add(edgeList);
        if (!Point.TO.equals(toOrFrom)) {
            matrix.get(linkIndex).set(matrix.size()-1, edge);
        }
    }

    public void addEdge(Integer indexA, Integer indexB, E edge) {
        if (matrix.size()<=indexA||matrix.size()<=indexB) {
            return;
        }
        matrix.get(indexA).set(indexB, edge);
    }

    public void queryLinkedVertex(Integer index) {
        
    }

    public void removeVertex(Integer index) {
        
    }

    public void removeEdge(Integer a, Integer b) {
        
    }

    public String traverseMatrix() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.size(); i++) {
            sb.append(vertexs.get(i)).append("\t");
            sb.append(matrix.get(i)).append("\n");
            
        }
        return sb.toString();
    }
    
    public String traverseByBreadth(Integer index) {
        StringBuilder sb = new StringBuilder();

        if (matrix.size()<=index) {
            return null;
        }
        
        return sb.toString();
    }

    public String traverseVertexs() {
        StringBuilder sb = new StringBuilder();
        for (V ver : vertexs) {
            sb.append(ver).append("\n");
        }
        return sb.toString();
    }

    
    public enum Point {
        TO,
        FROM,
        BIWAY
    }

    public static void main(String[] args) {
        Graph<String, String> graph = new Graph<String, String>("hello");
        graph.addVertex(Point.TO, 0,"world", "foo");
        graph.addVertex(Point.FROM, 1,"nihao", "foo");
        
        System.out.println(graph.traverseMatrix());
    }
}
