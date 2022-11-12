package com.greateLearning.groupG1AB6;

import java.util.LinkedList;

public class DataStorage {
    static Node root = null, newRoot = null, pNode = new Node(0);
    static Node createBST(int val, Node node){
        if (node == null) node = new Node(val);
        else {
            if (val < node.val) node.left = createBST(val, node.left);
            if (val > node.val) node.right = createBST(val,node.right);
        }
        return node;
    }
    static void createSkewBST(Node node){
        if (node != null) {
            createSkewBST(node.left);
            pNode.val = node.val;
            pNode = pNode.right = new Node(null);
            createSkewBST(node.right);
        }
    }

    public static void main(String[] args) {
        // hardCoded input
        root = createBST(50,root);
        root = createBST(30,root);
        root = createBST(60,root);
        root = createBST(10,root);
        root = createBST(55,root);
        root = createBST(40,root);
        root = createBST(90,root);
        root = createBST(20,root);
        root = createBST(14,root);
        root = createBST(5,root);

        newRoot = new Node(null);
        pNode = newRoot;
        // Creating the rightSkewed BST
        createSkewBST(root);
        pNode = null;
        // printing out the tree using level order traversal in ascending order
        display();

    }
    private static void display() {
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(newRoot);
        int j = 0;
        while (!stack.isEmpty()) {
            int s = stack.size();
            for (int i = 0; i < s; i++) {
                Node temp = stack.removeFirst();
                if (temp != null && temp.val != null) {
                    System.out.print(" ".repeat(j++) +temp.val);
                    if (temp.right != null && temp.right.val != null)
                        stack.add(temp.right);
                }
            }
            System.out.println();
            if (stack.size() > 0) System.out.println(" ".repeat(j++) + "\\");
        }
    }
}
