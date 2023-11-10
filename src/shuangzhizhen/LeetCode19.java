package shuangzhizhen;

import day01.ListNode;

/**
 * 删除链表的倒数第N个节点
 * 思路：双指针
 * 记住：虚拟头结点
 *
 * @author clearlove3
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //待删除节点的上一节点
        ListNode pre = null;
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        //删除该节点
        pre.next = slow.next;
        //释放待删除节点slow 的next指针
        slow.next = null;
        return dummy.next;
    }
}
