package LinkedList;

public class AlternateKNodeReverse {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node altReverseGroupSize(Node head, int k) {
        Node next = null;
        Node prev = null;
        Node current = head;
        int cnt = 0;
        /*1) reverse first k nodes of the linked list */
        while(current!=null && cnt < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            cnt++;
        }
        /* 2) Now head points to the kth node.  So change next
         of head to (k+1)th node*/
        if (head != null) {
            head.next = current;
        }

        int count = 0;
        /* 3) We do not want to reverse next k nodes. So move the current
         pointer to skip next k nodes */
        while(count < k-1 && current!=null) {
            current = current.next;
            count++;
        }
        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if(current!=null) {
            current.next = altReverseGroupSize(current.next, k);
        }
        return prev;
    }
    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    public void printList(Node head) {
        while(head!=null) {
            System.out.println(head.data+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        AlternateKNodeReverse obj = new AlternateKNodeReverse();
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
        obj.head = obj.altReverseGroupSize(obj.head, 3);
        obj.printList(obj.head);
    }
}
