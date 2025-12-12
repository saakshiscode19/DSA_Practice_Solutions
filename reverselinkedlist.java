import java.util.LinkedList;

public class reverselinkedlist {

    class Node{
        int data;
        Node next;

        Node(int data){
        this.data = data;
        this.next = null;
    }
}
Node head;
Node tail;

public void addFirst(int data){
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
    if (tail == null){
        tail = head;
    }


}
public void addLast(int data){
    Node newNode = new Node(data);
    if(head == null){
        head = newNode;
        return;

    }
   tail.next = newNode;
   tail = newNode;
    }
    

public void add(int index, int data){
    if (index == 0) {
        addFirst(data);
        return;
        
    }
    Node newNode = new Node(data);
    Node temp = head;
    int i = 0;
    while (temp != null && i < index -1) {
        temp = temp.next;
   
        i++;
    }
    if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
            if (newNode.next == null) tail = newNode;
        }

    }
    public void reverse(){
        Node prev = null;
        Node curr =  head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = head;
    head = prev;

}
public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

   
    public static void main(String[] args) {
 reverselinkedlist ll = new reverselinkedlist();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 3);
     System.out.println("Original Linked List:");
ll.print();
        ll.reverse();
            System.out.println("Reversed Linked List:");
        ll.print();
        
    }
}
 