package shuangzhizhen;

import day01.ListNode;

/**
 * 反转链表
 *
 * @author clearlove3
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        // ListNode n=head;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        //反转
        temp = cur.next;
        cur.next = prev;
        // 更新prev、cur位置
        prev = cur;
        cur = temp;
        return reverse(prev, cur);
    }
}
