public class LoopdetectLl {
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

public  boolean isCycle(){
Node  slow = head;
Node fast = head;
while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
    if(slow == fast){
        return true;
    }
} 
return false;
}


public static void main(String[] args) {

        LoopdetectLl ll = new LoopdetectLl();

        // Creating Linked List
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
// Creating a cycle manually
        ll.tail.next = ll.head.next.next;

        
System.out.println("cycle present ?" + ll.isCycle());
     
}
      
}
