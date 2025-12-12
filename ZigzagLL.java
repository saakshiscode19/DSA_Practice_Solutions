public class ZigzagLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    // Add at beginning (for testing)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
            
        }
    }

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
    // Print list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void zigZag(){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL;
        Node nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;

            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
  
 public static void main(String[] args) {
  ZigzagLL ll = new ZigzagLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
  ll.print();
 ll.zigZag();
   ll.print();
    }
    }

 