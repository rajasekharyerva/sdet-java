package tree;

import java.util.*;

// TreeNode class to represent a node in the Binary Search Tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTClosest {

    // Function to find k closest values
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // Min-heap to store the closest k values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> Math.abs(a - target) == Math.abs(b - target) ? b - a : (int) (Math.abs(a - target) - Math.abs(b - target))
        );

        // Result list to store the k closest values
        List<Integer> result = new ArrayList<>();

        // Perform DFS traversal to find k closest values
        dfs(root, target, k, minHeap);

        // Extract the k closest values from the min-heap into the result list
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        // Reverse the result list to return values in correct order
        Collections.reverse(result);
        return result;
    }

    // Helper DFS function to traverse the tree and add nodes to the min-heap
    private void dfs(TreeNode root, double target, int k, PriorityQueue<Integer> heap) {
        if (root == null) return;

        // Add the current node's value to the heap
        heap.offer(root.val);

        // If the heap exceeds size k, remove the largest element
        if (heap.size() > k) heap.poll();

        // Traverse left or right subtree based on the target value
        if (target < root.val) {
            dfs(root.left, target, k, heap);
        } else {
            dfs(root.right, target, k, heap);
        }
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        // Example tree:
        //       4
        //     /   \
        //    faq2     5
        //   / \
        //  1   3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        BSTClosest solution = new BSTClosest();
        List<Integer> closestValues = solution.closestKValues(root, 3.714, 3);

        // Output the k closest values
        System.out.println(closestValues);  // Output should be [3, 4, faq2]
    }
}
