package day01;

public class LeetCode142 {
    /**
     * 环形链表2
     * 需要返回相交的点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode slow = head;
        //首先判断是否有相交
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            ListNode p = head;
            while (p != slow) {
                p = p.next;
                slow = slow.next;
            }
            return p;
        } else {
            return null;
        }
    }
}
