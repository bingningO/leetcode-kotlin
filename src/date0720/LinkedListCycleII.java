package date0720;

import javaUtil.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(node1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        List<ListNode> lists = new ArrayList<>();
        ListNode pt= head;
        while(pt != null) {
            if (lists.contains(pt)) {
                return pt;
            }
            lists.add(pt);
            pt = pt.next;
        }
        return null;
    }
}
