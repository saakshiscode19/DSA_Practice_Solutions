public class Llpalindrome {
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
//fast slow approach
public Node findMid(Node head){
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next; //+1
        fast = fast.next.next; //+2
    
    }
    return slow;
} 
public boolean checkPalindrome(){
    if(head == null || head.next == null){
        return true;
    }
    // find mid
    Node midNode = findMid(head);
//reverse 2nd half

Node prev = null;
Node curr = midNode;
Node next;
while(curr != null){
    next = curr. next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
Node right = prev;
Node left = head;

// check left half and right half
while (right!= null ) {
    if (left.data != right.data) {
        return false;
        
    }
    left = left.next;
    right = right.next;
    
}
return true;
}



  public static void main(String[] args) {
Llpalindrome ll = new Llpalindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(1);

     

        System.out.println(ll.checkPalindrome());
}
}
