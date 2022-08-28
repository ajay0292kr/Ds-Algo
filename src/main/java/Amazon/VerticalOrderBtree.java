package Amazon;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderBtree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
        static void getVerticalOrder(Node root, int hd, TreeMap<Integer,Vector<Integer>> m) {
            if (root == null) {
                return;
            }
            Vector<Integer> get =  m.get(hd);
            if(get == null) {
                new Vector<Integer>();
                get.add(root.data);
            }else {
                get.add(root.data);
            }
            m.put(hd, get);
            getVerticalOrder(root.left, hd-1, m);
            getVerticalOrder(root.right, hd+1, m);

        }
        static void printVerticalOrder(Node root) {
            TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
            int hd =0;
            getVerticalOrder(root,hd,m);
            for (Map.Entry<Integer, Vector<Integer>> res: m.entrySet()) {
                System.out.println(res.getValue());
            }
        }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
