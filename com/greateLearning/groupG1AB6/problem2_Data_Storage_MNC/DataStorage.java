package com.greateLearning.groupG1AB6.problem2_Data_Storage_MNC;

public class DataStorage {
    static Node root = null, newRoot = null, pNode = new Node(0);

    // function to create BST
    static Node createBST(int key, Node node) {
        if (node == null)
            return (new Node(key));

        if (key < node.val)
            node.left = createBST(key, node.left);
        else if (key > node.val)
            node.right = createBST(key, node.right);
        else
            System.out.println("No Duplicate allowed this node is not going to add in BST");

        return node;
    }

    static void createSkewBST(Node node) {
        if (node != null) {
            createSkewBST(node.left);
            pNode.val = node.val;
            pNode = pNode.right = new Node(null);
            createSkewBST(node.right);
        }
    }

    public static void main(String[] args) {
        // hardCoded input
        root = createBST(50, root);
        root = createBST(30, root);
        root = createBST(60, root);
        root = createBST(10, root);
        root = createBST(55, root);

        newRoot = new Node(null);
        pNode = newRoot;
        // Creating the rightSkewed BST
        createSkewBST(root);
        pNode = null;
        // printing out the tree using level order traversal in ascending order
        display(newRoot);

    }

    private static void display(Node root) {
        if (root == null)
            return;
        if (root.val != null) System.out.print(root.val + " ");
        display(root.right);
    }
}
