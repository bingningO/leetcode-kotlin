package date0720;
import javaUtil.ListNode;



public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;
        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slowP = head.next;
        ListNode fastP = head.next.next;
        while (slowP != null && fastP != null) {
            if (slowP.equals(fastP)) {
                return true;
            }
            slowP = slowP.next;
            if (fastP.next == null) return false;
            fastP = fastP.next.next;
        }
        return false;
    }

}
