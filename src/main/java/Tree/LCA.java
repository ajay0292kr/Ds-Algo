package Tree;

public class LCA {
    TreeNode lca(TreeNode root, int n1, int n2) {
        if (root.val == n1 || root.val == n2) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }
        TreeNode left = null, right = null;
        if (root.left != null) {
                left = lca(root.left, n1, n2);
        }
        if (root.right != null) {
            right = lca(root.right, n1, n2);
        }

        if (left != null && right != null) {
            return root;
        }
        return left == null ? left:right;
    }
}
