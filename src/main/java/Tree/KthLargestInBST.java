package Tree;

public class KthLargestInBST {
    private int count = 0;    // Counter to keep track of visited nodes
    private int result = -1;  // Variable to store the result

    public int kthLargest(TreeNode root, int k) {
        reverseInOrderTraversal(root, k);
        return result;
    }

    private void reverseInOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree first
        reverseInOrderTraversal(node.right, k);

        // Increment the count for each node visited
        count++;
        // If count matches k, we've found the k-th smallest element
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse the right subtree
        reverseInOrderTraversal(node.left, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthLargestInBST bst = new KthLargestInBST();
        int k = 3;
        System.out.println("The " + k + "th smallest element is: " + bst.kthLargest(root, k));
    }
}
