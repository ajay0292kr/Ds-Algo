package LinkedList;

public class ReverseGroupOfSize {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node reverseGroupSize(Node head, int k) {
        if(head == null) return head;
        Node current = head;
        Node next = null;
        Node prev = null;

        int cnt = 0;
        while (current!=null && cnt < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            cnt++;
        }
        if(next!=null) {
            head.next = reverseGroupSize(next, k);
        }
        return prev;
    }
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ReverseGroupOfSize obj = new ReverseGroupOfSize();
        obj.push(9);
        obj.push(8);
        obj.push(7);
        obj.push(6);
        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(1);
        int k = 3;
        obj.head = obj.reverseGroupSize(obj.head, 3);
        obj.printList();
    }
}
