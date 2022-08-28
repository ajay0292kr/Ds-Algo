package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {
    // Print Left View of a Binary Tree
    Node root;
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static void printLeftView(Node root) {
        if (root == null) return ;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                Node temp = q.poll();
               // q.remove();
                if (i == 1) {
                    System.out.print(temp.data+" ");
                }
                assert temp != null;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);
        printLeftView(root);
    }
}
