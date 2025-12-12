public class RemoveLoopeLl {
 
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

//detect cycle
public boolean isCycle(){
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
public void removeCycle(){
Node  slow = head;
Node fast = head;
boolean cycle = false;
while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
    if(slow == fast){
       cycle = true;
       break;
}
}
if ( cycle == false ) {
    return;
}
slow = head;
Node prev = null;
 // Step 3: move slow and fast one-one step
        // when they meet again, fast will be at loop start
        // prev will be last node in loop
while (slow != fast) {
    prev = fast;
    slow = slow.next;
    fast = fast.next;

}
prev.next = null;
tail = prev; //optional
}

public void print(){
Node temp = head;
while(temp != null){
    System.out.println(temp.data + "->");
    temp = temp.next;
}
System.out.println();
}
public static void main(String[] args) {

      RemoveLoopeLl ll = new RemoveLoopeLl();

        // Creating Linked List
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
// Creating a cycle manually
        ll.tail.next = ll.head.next.next;

        
System.out.println("cycle present ?" + ll.isCycle());
     ll.removeCycle();
     System.out.println("Cycle present after removel?"+ ll.isCycle());
     ll.print();
}
      
}

