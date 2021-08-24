package M8D7;

import day01.ListNode;

import java.util.List;

/**
 * 翻转链表2
 * 从left翻转到right
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //注意，一般要设置dummyNode
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        if(head==null||head.next==null)
            return head;
        for (int i = 0; i < left-1; i++) {
            pre=pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i=0;i<right-left;i++){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummyNode.next;
    }
}
