package Amazon;

public class InsertInCircularList {
    Node head;
    // Java program for sorted insert in circular linked list
    static class Node {
        int d;
        Node next;
        Node(int data) {
            d = data;
            next = null;
        }
    }
    InsertInCircularList()   { head = null; }
    void sortedInsert(Node new_node) {
        Node current = head;
        if (current == null)
        {
            new_node.next = new_node;
            head = new_node;
        }
        else if (current.d >= new_node.d)
        {
            /* If value is smaller than head's value then
             we need to change next of last node */
            while (current.next != head)
                current = current.next;

            current.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        else
        {

            /* Locate the node before the point of insertion */
            while (current.next != head &&
                    current.next.d < new_node.d)
                current = current.next;

            new_node.next = current.next;
            current.next = new_node;
        }
    }
    void printList()
    {
        if (head != null)
        {
            Node temp = head;
            do
            {
                System.out.print(temp.d + " ");
                temp = temp.next;
            }  while (temp != head);
        }
    }

    public static void main(String[] args) {
        InsertInCircularList list = new InsertInCircularList();
        int[] arr = new int[] {12, 56, 2, 11, 1, 90};
        Node temp = null;
        for (int i = 0; i < 6; i++)
        {
            temp = new Node(arr[i]);
            list.sortedInsert(temp);
        }

        list.printList();
    }
}
