package day01;

public class LeetCode141 {
    /**
     * 是否有环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode fast=head;
        ListNode slow=head;
        fast=fast.next;
        while(fast!=null&&slow!=null){
            if(fast==slow)
                return true;
            fast=fast.next;
            slow=slow.next;
            if(fast!=null)
                fast=fast.next;
        }
        return false;
    }
}
