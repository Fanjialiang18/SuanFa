package linklist;

import day01.ListNode;

/**
 * 两两交换链表中的节点
 * @author clearlove3
 */
public class LeetCode24 {
    /**
     * 迭代
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head,pre=dummy,next;
        while (cur!=null&&cur.next!=null){
            next=cur.next.next;
            pre.next=cur.next;
            cur.next.next=cur;
            cur.next=next;
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) {
            return head;
        }
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs2(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;
        //返回的是交换后的第一个节点，即原来的第二个节点
        return next;
    }
}
