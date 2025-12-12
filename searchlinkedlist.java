public class searchlinkedlist {

    class Node{
        int data;
        Node next;

        Node(int data){
        this.data = data;
        this.next = null;
    }
}
Node head;

public void addFirst(int data){
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;

}
public void addLast(int data){
    Node newNode = new Node(data);
    if(head == null){
        head = newNode;
        return;

    }
    Node temp = head;
    while(temp.next != null){
        temp = temp.next;
    }
    temp.next = newNode;
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
        temp.next = newNode;
        i++;
        
    }

}
    public int itrsearch(int key){
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public void print()
    {
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int helper(Node head, int key){
if(head == null){
    return -1;
}
if(head.data == key){
    return 0;
}
int idx = helper(head.next, key);
if (idx == -1) {
    return -1;
    
}
return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }
    public static void main(String[] args) {
        searchlinkedlist ll = new searchlinkedlist();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 3);

        ll.print();
        System.out.println(ll.recSearch(3));
          System.out.println(ll.recSearch(10));
    }
}
