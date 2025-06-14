package Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class KthSmallestElement {
    private int count = 0;    // Counter to keep track of visited nodes
    private int result = -1;  // Variable to store the result

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree first
        inOrderTraversal(node.left, k);

        // Increment the count for each node visited
        count++;
        // If count matches k, we've found the k-th smallest element
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestElement bst = new KthSmallestElement();
        int k = 3;
        System.out.println("The " + k + "th smallest element is: " + bst.kthSmallest(root, k));
    }
}
