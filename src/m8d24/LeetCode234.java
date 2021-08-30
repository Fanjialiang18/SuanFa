package m8d24;

import day01.ListNode;

/**
 * 回文链表
 * 快慢指针
 * 思路：
 *  快慢指针找到中点，逆序后半，然后比较
 *
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow=head,fast=head;
        //快慢指针找到中点
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //翻转后半部分链表
        ListNode pre=reverse(slow);
        while (head!=null&&pre!=null){
            if(head.val!=pre.val) {
                return false;
            }
            head=head.next;
            pre=pre.next;
        }
        return true;
    }

    private ListNode reverse(ListNode root){
        ListNode pre=null,nex;
        while (root!=null){
            nex=root.next;
            root.next=pre;
            pre=root;
            root=nex;
        }
        return pre;
    }
}
