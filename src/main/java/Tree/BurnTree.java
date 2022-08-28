package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BurnTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int search(TreeNode root, int num, Map<Integer, Set<Integer>> levelOrderMap) {
        if(root!=null) {
            if(root.val == num) {
                levelOrderStoredInMap(root.left, 1, levelOrderMap);
                levelOrderStoredInMap(root.right, 1, levelOrderMap);
                return 1;
            }
            int k = search(root.left, num, levelOrderMap);
            if (k >0) {
                storeRootAtK(root, k, levelOrderMap);
                levelOrderStoredInMap(root.right, k + 1,
                        levelOrderMap);
                return k+1;
            }
            k = search(root.right, num, levelOrderMap);
            if (k > 0)
            {
                // store root in map with k
                storeRootAtK(root, k, levelOrderMap);
                // store level order for other branch
                levelOrderStoredInMap(root.left, k + 1,
                        levelOrderMap);
                return k + 1;
            }

        }
        return -1;
    }
    public static void levelOrderStoredInMap(
            TreeNode root, int k, Map<Integer, Set<Integer> > levelOrderMap)
    {
        if (root != null) {
            storeRootAtK(root, k, levelOrderMap);
            levelOrderStoredInMap(root.left, k + 1,
                    levelOrderMap);
            levelOrderStoredInMap(root.right, k + 1,
                    levelOrderMap);
        }
    }
    private static void
    storeRootAtK(TreeNode root, int k, Map<Integer, Set<Integer> > levelOrderMap)
    {
        if (levelOrderMap.containsKey(k)) {
            levelOrderMap.get(k).add(root.val);
        }
        else {
            Set<Integer> set = new HashSet<>();
            set.add(root.val);
            levelOrderMap.put(k, set);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        TreeNode left = root.right.left;
        TreeNode right = root.right.right;
        left.left = new TreeNode(21);
        left.right = new TreeNode(24);
        right.left = new TreeNode(22);
        right.right = new TreeNode(23);

        Map<Integer, Set<Integer>> levelOrderMap
                = new HashMap<>();
        search(root, 14, levelOrderMap);
        System.out.println(14);
        for (Integer level : levelOrderMap.keySet())
        {
            for (Integer val : levelOrderMap.get(level))
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
