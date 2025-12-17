import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeQ {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println(deque);
    }
}
