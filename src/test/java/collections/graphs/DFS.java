package collections.graphs;

import java.util.*;

// Graph class to represent a graph
class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a new edge from u to v
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph, add the reverse edge
    }

    // Depth-First Search (DFS) recursive function
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    // Helper function to perform DFS recursively
    private void dfsRecursive(int node, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(node);
        System.out.print(node + " "); // Print the current node (or process it)

        // Recur for all the neighbors of the current node
        if (adjList.containsKey(node)) {
            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    dfsRecursive(neighbor, visited);
                }
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        // Create a graph object
        Graph graph = new Graph();

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform DFS starting from node 0
        System.out.println("DFS starting from node 0:");
        graph.dfs(0);
    }
}

