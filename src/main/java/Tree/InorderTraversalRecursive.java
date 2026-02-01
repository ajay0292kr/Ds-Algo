package Tree;


import java.util.Stack;

public class InorderTraversalRecursive {
    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      inorder(root); // Output 4 2 5 1 3
    }
    // Iterative Inorder Traversal (Using Stack)
    public static void push1(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;

      while (current != null || !stack.isEmpty()) {
          // Reach the left most node
          while (current != null) {
              stack.push(current);
              current = current.left;
          }
          // current must be null at this point
          current = stack.pop();
          System.out.print(current.val + " ");
          // visit the right subtree
            current = current.right;
      }
    }
}
