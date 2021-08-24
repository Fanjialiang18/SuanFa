package M8D7;

import day01.ListNode;


/**
 * 链表中的倒数第K个节点
 * 思路：两个距离K的指针，后指针移到末尾即可、
 * 前指针就是倒数第K个
 */
public class LeetCode22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p=head;
        for(int i=0;i<k-1;i++){
            p=p.next;
        }
        while (p.next!=null){
            p=p.next;
            head=head.next;
        }
        return head;
    }
}
