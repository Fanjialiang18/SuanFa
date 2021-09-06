package linklist;

import day01.ListNode;

/**
 * 反转链表
 * @author clearlove3
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode pre=null,cur=head,next;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null,head);
    }

    private ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null){
            return pre;
        }
        ListNode next=cur.next;
        cur.next=pre;
        pre=cur;
        cur=next;
        return reverse(pre,cur);
    }
}
