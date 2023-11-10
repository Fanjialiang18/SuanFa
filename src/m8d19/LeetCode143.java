package m8d19;

import day01.ListNode;

/**
 * 重排链表
 * 思路：1.快慢指针找到中点 2.拆成两个链表 3.遍历两个链表，后面的塞到前面的“缝隙里”
 */
public class LeetCode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        //找到中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //后半链表反转
        ListNode rev = slow.next;
        slow.next = null;
        rev = reverse(rev);
        //插入前半缝隙中
        ListNode cur = head;
        while (cur != null && rev != null) {
            ListNode ins = rev;
            rev = rev.next;
            ListNode nexCur = cur.next;
            ins.next = cur.next;
            cur.next = ins;
            cur = nexCur;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
