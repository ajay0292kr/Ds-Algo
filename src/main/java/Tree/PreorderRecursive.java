package Tree;

import java.util.Stack;

public class PreorderRecursive {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        preorder(root);  // Output: 1 2 4 5 3
    }
    public static void preorder(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    // Iterative using stack
    public static void preOrder(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");

            // push right first
            if (node.right != null) {
                stack.push(node.right);
            }

            // Push left
            if (node.left != null) {
                stack.push(node.left);
            }

        }
    }
}
