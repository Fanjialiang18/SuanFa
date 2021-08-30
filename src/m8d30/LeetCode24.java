package m8d30;

import day01.ListNode;

/**
 * 两两交换链表中的节点
 * 思路1：
 *  递归
 * 思路2：
 *  迭代
 * @author clearlove3
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next = head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode cur=head,pre=dummy;
        while (cur!=null&&cur.next!=null){
            ListNode next=cur.next;
            cur.next=cur.next.next;
            next.next=cur;
            pre.next=next;
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
