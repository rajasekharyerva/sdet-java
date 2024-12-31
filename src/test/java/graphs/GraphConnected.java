package graphs;

import java.util.*;

class GraphConnected {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public GraphConnected(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u); // Undirected graph
    }

    // Perform DFS traversal from a given node
    private void DFS(int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    // Check if the graph is connected
    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];

        // Start DFS from the first node (vertex 0)
        DFS(0, visited);

        // Check if all vertices were visited
        for (boolean visitedNode : visited) {
            if (!visitedNode) {
                return false; // If any vertex is not visited, graph is disconnected
            }
        }
        return true; // All vertices are reachable
    }

    public static void main(String[] args) {
        GraphConnected graph = new GraphConnected(5); // Graph with 5 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        // Check if the graph is connected
        System.out.println("Is the graph connected? " + graph.isConnected());
    }
}

