package Tree;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // if left child is null recurse right
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // if right child is null, recurse left
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        // Both children exists
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
