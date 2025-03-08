package collections.arrays;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    // Insert a value into the BST
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    // Add elements of the array to the BST
    public void addArray(int[] arr) {
        for (int value : arr) {
            insert(value);
        }
    }

    // Inorder traversal (sorted order for BST)
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }
}

public class AddBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Array to add to the BST
        int[] elements = {10, 5, 15, 3, 7, 13, 18};

        // Add array elements to the BST
        bst.addArray(elements);

        // Print the BST in sorted order
        System.out.println("Inorder Traversal of BST:");
        bst.inorderTraversal(bst.root);
    }
}

