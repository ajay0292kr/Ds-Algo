package Amazon;

import com.sun.source.tree.BinaryTree;
import com.sun.tools.javac.tree.JCTree;

class Node {
    int data;
    Node left, right;
    public Node(int d) {
        data = d;
        left = right = null;
    }
}
public class DiameterOfTree {
    // Diameter of a Binary Tree
    Node root;
    int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        // get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);
        // get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1 , Math.max(ldiameter, rdiameter));
    }
    int diameter() {
        return diameter(root);
    }
    int height(Node root) {
        if (root == null) {
            return 0;
        }
        return (1 + Math.max(height(root.left), height(root.right)));
    }
    public static void main(String[] args) {
        DiameterOfTree tree = new DiameterOfTree();
        tree.root  = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right  = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.diameter());
    }
}
