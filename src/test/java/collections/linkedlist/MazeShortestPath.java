package collections.arrays.linkedlist;

import java.util.*;
import java.util.LinkedList;

public class MazeShortestPath {
    static class Point {
        int x, y, steps;

        Point(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public static int shortestPath(int[][] maze, int[] start, int[] end) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Directions for movement: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Visited array
        boolean[][] visited = new boolean[rows][cols];
        visited[start[0]][start[1]] = true;

        // BFS queue
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1], 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // Check if we've reached the destination
            if (current.x == end[0] && current.y == end[1]) {
                return current.steps;
            }

            // Explore neighbors
            for (int[] direction : directions) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                // Check if the new position is within bounds and not visited
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                        && maze[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY, current.steps + 1));
                }
            }
        }

        // If we exit the loop without finding the destination, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[] start = {0, 0};
        int[] end = {4, 4};

        int result = shortestPath(maze, start, end);
        System.out.println(result != -1 ? "Shortest path length: " + result : "No path found");
    }
}

