package Tree;

public class BSTtree {
    int isBST(TreeNode root)
    {
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private int isBST(TreeNode root,int min,int max)
    {
        if(root==null)
            return 1;
        if(root.val<min||root.val>max)
            return 0;
        int x = isBST(root.left, min,root.val);
        int y = isBST(root.right,root.val, max);
        if(x==1 && y==1)
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) {

    }
}
