public class linkedlist {
public static class Node{
    int data;
    int next;
    public Node(int data){
        this.data= data;
        this.next = null;
    }
}
public static Node head;
public static Node tail;

public void addFirst(int data){
// strp 1: create new node
Node newNode = new Node(data);
if (head == null) {
    head = tail = newNode;
        return;
    
}
//step 2: newNode   next = head
Node.next = head;

// step3 = head = newNode
head = newNode;
}
public static void main(String[] args) {
    linkedlist ll = new linkedlist();
    ll.addFirst(1);
    ll.addFirst(2);
}
}
 