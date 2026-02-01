package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {
    public List<Integer> BoundaryOfBinaryTree(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if (root == null) return result;
       // Root (only if not leaf)
        if(!isLeaf(root)) {
            result.add(root.val);
        }
        addLeftBoundry(root.left, result);
        addLeaves(root, result);
        addRightBoundry(root.right, result);

        return result;
    }
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    private void addLeftBoundry(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            }else {
                node = node.right;
            }
        }
    }
    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if(isLeaf(node)) {
            result.add(node.val);
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }
    private void addRightBoundry(TreeNode node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if(!isLeaf(node)) {
                stack.push(node.val);
            }
            if (node.right != null) {
                node = node.right;
            }
            if (node.left != null) {
                node = node.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
    public static void main(String[] args) {

    }
}
