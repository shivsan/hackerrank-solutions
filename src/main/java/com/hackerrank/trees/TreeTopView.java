package com.hackerrank.trees;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        traverseAndAddLeftTopViewElements(root);
        traverseAndAddRightTopViewElements(root);

        for(int i = 0; i< topViewValues.size(); i++) {
            System.out.print(topViewValues.get(i) + " ");
        }
    }

    public static void traverseAndAddLeftTopViewElements(Node cursor) {
        if(cursor == null)
            return;

                    traverseAndAddLeftTopViewElements(cursor.left);
        topViewValues.add(cursor.data);
    }

    public static void traverseAndAddRightTopViewElements(Node cursor) {
        if(cursor == null)
            return;

                    traverseAndAddRightTopViewElements(cursor.right);
        topViewValues.add(cursor.data);
    }

    public static List<Integer> topViewValues = new ArrayList<>();

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
