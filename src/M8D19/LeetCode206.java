package M8D19;

import day01.ListNode;

/**
 * 反转链表
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
