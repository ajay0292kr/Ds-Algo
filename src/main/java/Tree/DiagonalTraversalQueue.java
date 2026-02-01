package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversalQueue {
    public List<List<Integer>> diagonalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> diagonal = new ArrayList<>();
            while (--size >0) {
                TreeNode node = queue.poll();

                // Traverse all nodes int current diagonal
                while (node != null) {
                    diagonal.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    node = node.right;
                }
            }
            result.add(diagonal);
        }
        return result;
    }
}
