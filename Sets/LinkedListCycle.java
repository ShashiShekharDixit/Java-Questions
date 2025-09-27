import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (seen.contains(current)) {
                return true; 
            }
            seen.add(current);
            current = current.next;
        }
        return false; 
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; 
        System.out.println("Linked list has cycle = " + hasCycle(n1));
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(7);
        m1.next = m2;
        m2.next = m3;
        System.out.println("Linked list has cycle = " + hasCycle(m1));
    }
}
