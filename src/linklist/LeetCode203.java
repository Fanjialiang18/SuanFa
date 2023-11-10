package linklist;

import day01.ListNode;

/**
 * 移除链表元素
 * 使用虚拟头节点
 *
 * @author clearlove3
 */
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
