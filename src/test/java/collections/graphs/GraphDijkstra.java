package collections.graphs;

import java.util.*;

class GraphDijkstra {
    private int vertices;
    private LinkedList<Edge>[] adjList;

    static class Edge {
        int target, weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    GraphDijkstra(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int target, int weight) {
        adjList[source].add(new Edge(target, weight));
        adjList[target].add(new Edge(source, weight)); // For undirected graph
    }

    void dijkstra(int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.target;

            for (Edge neighbor : adjList[currentVertex]) {
                int newDist = dist[currentVertex] + neighbor.weight;

                if (newDist < dist[neighbor.target]) {
                    dist[neighbor.target] = newDist;
                    pq.add(new Edge(neighbor.target, newDist));
                }
            }
        }

        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        GraphDijkstra graph = new GraphDijkstra(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 5, 9);

        int source = 0;
        System.out.println("Dijkstra's Algorithm:");
        graph.dijkstra(source);
    }
}

