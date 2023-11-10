package linklist;

import day01.ListNode;

/**
 * 环形链表 II
 * 先找交点，然后从交点和起点出发，慢慢走，交点就是环的入口
 *
 * @author clearlove3
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //找到环
            if (slow == fast) {
                ListNode start = head, point = fast;
                //从起点和交点同时出发，同时走遇到时候就是交点
                while (start != fast) {
                    start = start.next;
                    point = point.next;
                }
                return start;
            }
        }
        return null;
    }
}
