package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {
    public List<List<Integer>> diagonalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, 0, map);

        return new ArrayList<>(map.values());
    }

    private void dfs(TreeNode node, int d, Map<Integer, List<Integer>> map) {
        if (node == null) return;

        map.putIfAbsent(d, new ArrayList<>());
        map.get(d).add(node.val);

        // Left child -> next diagonal
        dfs(node.left, d+1, map);
        // Right child - same diagonal
        dfs(node.right, d, map);
    }
}
