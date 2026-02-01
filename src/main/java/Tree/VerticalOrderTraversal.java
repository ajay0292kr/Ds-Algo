package Tree;

import java.util.*;

class Pair {
    TreeNode node;
    int col;
    Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // column -> list of node
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int col = p.col;
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) queue.offer(new Pair(node.left, col - 1));
            if (node.right != null) queue.offer(new Pair(node.right, col + 1));
        }
        for (List<Integer> list : map.values()) {
            result.add(list);
        }

        return result;
    }
    public static void main(String[] args) {

    }
}
