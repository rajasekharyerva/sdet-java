package collections.tree;

class BinaryTree {
    Node root;

    // Function to calculate the height of the binary collections.tree
    static int height(Node node) {
        if (node == null) {
            return 0; // Height of an empty collections.tree is 0
        }

        // Recursive call to calculate height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Return the greater height + 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Creating a sample collections.tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Calculating and printing the height of the collections.tree
        System.out.println("Height of collections.tree is : " + tree.height(tree.root));
    }
}

