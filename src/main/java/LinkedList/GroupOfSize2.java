package LinkedList;

import java.util.Stack;

public class GroupOfSize2 {
    static Node head = null;
    static class Node {
        int data;
        Node next;
    }
    static Node Reverse(Node head, int k) {
        Stack<Node> st = new Stack<>();
        Node current = head;
        Node prev = null;
        while (current!=null) {
            int count = 0;

            while(current!=null && count < k) {
                st.push(current);
                current = current.next;
                count++;
            }
            while(st.size() > 0) {
                if(prev !=null) {
                    prev = st.peek();
                    head = prev;
                    st.pop();
                }else {
                    prev.next = st.peek();
                    prev = prev.next;
                    st.pop();
                }
            }
        }
        prev.next = null;
        return head;
    }
    static void push(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head;
        head = new_node;
    }
    static void printList(Node node) {

        while (node!=null) {
            System.out.println(node.data+" ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        push( 9);
        push( 8);
        push( 7);
        push( 6);
        push( 5);
        push(4);
        push(3);
        push(2);
        push( 1);
        System.out.println("Given linked list ");
        printList(head);
        head = Reverse(head, 3);
        System.out.println();

        System.out.println("Reversed Linked list ");
        printList(head);
    }
}
