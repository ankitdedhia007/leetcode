package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class FindTheTownJudge_997 {

    int noOfVertices;
    LinkedList<Integer> adj[];

    public FindTheTownJudge_997(int vertices) {
        noOfVertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adj[i] = new LinkedList();
    }

    private void addEdge(int vertex, int adjacent) {
        adj[vertex].add(adjacent);
    }

    private void BFS(int vertex) {
        boolean[] visited = new boolean[noOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            int val = queue.poll();
            System.out.print(val + " ");

            Iterator<Integer> itr = adj[val].listIterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        FindTheTownJudge_997 graph = new FindTheTownJudge_997(2);
        graph.addEdge(1, 2);
       /* graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);*/

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        graph.BFS(1);
    }
}
