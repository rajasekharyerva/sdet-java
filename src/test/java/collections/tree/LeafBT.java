package collections.tree;

class LeafBT {
    Node root;

    // Function to print all leaf nodes
    void printLeafNodes(Node node) {
        if (node == null) {
            return;
        }

        // If the node is a leaf node (no children)
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        // Recursively check the left and right subtrees
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    public static void main(String[] args) {
        LeafBT tree = new LeafBT();

        // Creating a sample collections.tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        //collections.tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Leaf nodes of the binary collections.tree:");
        tree.printLeafNodes(tree.root);
    }

}
