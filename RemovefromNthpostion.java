public class RemovefromNthpostion {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;

        }
    }

    Node head;
    Node tail;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // remove from nth postion
    public void deleteNthfromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;

        }
        if (n == sz) {
            head = head.next;// remove first
            return;

        }
        // sz-n
        int i = 1;
        int iToFind = sz - n;

        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;

        }
        // delete the node
        prev.next = prev.next.next;

        // update tail if last deleted
        if (prev.next == null) {
            tail = prev;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemovefromNthpostion ll = new RemovefromNthpostion();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        System.out.println("original List");
        ll.print();
        ll.deleteNthfromEnd(3);
        System.err.println("After Deleting nth from end");

        ll.print();
    }

}
