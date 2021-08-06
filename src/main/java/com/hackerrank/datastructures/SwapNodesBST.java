package com.hackerrank.datastructures;

public class SwapNodesBST {

}

class BinaryTree {
    private Node root;

    public int[][] swapNodes() {
        return null;
    }

    public void add(int i) {
        if (root == null)
            root = new Node(i);
        else {
            Node parent = root;
            Node current = root;

            while (current != null) {
                if (current.value > i) {
                    parent = current;
                    current = current.left;
                } else {
                    parent = current;
                    current = current.right;
                }
            }

            if (parent.value > i)
                parent.left = new Node(i);
            else
                parent.right = new Node(i);
        }
    }

    public Node search(int i) {
        Node current = root;

        while (current != null) {
            if (current.value == i)
                return current;

            if (current.value > i) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(Node root) {
        if (root == null)
            return;

        inOrderTraversalRec(root.left);
        System.out.println(root.value);
        inOrderTraversalRec(root.right);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int i) {
        value = i;
    }
}
