package LinkedList;

public class AddTwoList {
    Node head1, head2, result;
    int carry;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    void push(int val, int list) {
        Node newnode = new Node(val);
        if (list == 1)
        {
            newnode.next = head1;
            head1 = newnode;
        }
        else if (list == 2)
        {
            newnode.next = head2;
            head2 = newnode;
        }
        else
        {
            newnode.next = result;
            result = newnode;
        }
    }
    void addsamesize(Node n, Node m)
    {
        // Since the function assumes linked lists are of
        // same size, check any of the two head pointers
        if (n == null)
            return;

        // Recursively add remaining nodes and get the carry
        addsamesize(n.next, m.next);

        // add digits of current nodes and propagated carry
        int sum = n.data + m.data + carry;
        carry = sum / 10;
        sum = sum % 10;

        // Push this to result list
        push(sum, 3);

    }
    Node current;
    void propogatecarry(Node head1)
    {
        // If diff. number of nodes are not traversed, add carry
        if (head1 != current)
        {
            propogatecarry(head1.next);
            int sum = carry + head1.data;
            carry = sum / 10;
            sum %= 10;

            // add this node to the front of the result
            push(sum, 3);
        }
    }
    int getsize(Node head)
    {
        int count = 0;
        while (head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
    void addlists()
    {
        // first list is empty
        if (head1 == null)
        {
            result = head2;
            return;
        }

        // first list is empty
        if (head2 == null)
        {
            result = head1;
            return;
        }

        int size1 = getsize(head1);
        int size2 = getsize(head2);

        // Add same size lists
        if (size1 == size2)
        {
            addsamesize(head1, head2);
        }
        else
        {
            // First list should always be larger than second list.
            // If not, swap pointers
            if (size1 < size2)
            {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int diff = Math.abs(size1 - size2);

            // move diff. number of nodes in first list
            Node temp = head1;
            while (diff-- >= 0)
            {
                current = temp;
                temp = temp.next;
            }

            // get addition of same size lists
            addsamesize(current, head2);

            // get addition of remaining first list and carry
            propogatecarry(head1);
        }
        // if some carry is still there, add a new node to
        // the front of the result list. e.g. 999 and 87
        if (carry > 0)
            push(carry, 3);

    }
    void printlist(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        AddTwoList addlist = new AddTwoList();
        addlist.head1 = null;
        addlist.head2 = null;
        addlist.result = null;
        addlist.carry = 0;
        int arr1[] = { 9, 9, 9 };
        int arr2[] = { 1, 8 };

        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            addlist.push(arr1[i], 1);

        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            addlist.push(arr2[i], 2);

        addlist.addlists();

        addlist.printlist(addlist.result);
    }
}
