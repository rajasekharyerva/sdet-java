package collections.tree;

class BinaryTree2 {
    Node root;

    // Function to reverse (mirror) the binary collections.tree
    Node reverse(Node node) {
        if (node == null) {
            return null; // Base case: if collections.tree is empty
        }

        // Recursively reverse left and right subtrees
        Node left = reverse(node.left);
        Node right = reverse(node.right);

        // Swap the left and right children
        node.left = right;
        node.right = left;

        return node; // Return the root of the reversed collections.tree
    }

    // Function to perform in-order traversal
    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree2 tree = new BinaryTree2();

        // Creating a sample collections.tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("In-order traversal of original collections.tree:");
        tree.inOrder(tree.root);

        // Reverse the binary collections.tree
        tree.reverse(tree.root);

        System.out.println("\nIn-order traversal of reversed collections.tree:");
        tree.inOrder(tree.root);
    }
}
