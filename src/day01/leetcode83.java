package day01;

public class leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        boolean flag = false;  //标记数是否需要被删除
        int num = -101;    //需要删除的数
        ListNode p = dummy, q = head;
        while (q != null && q.next != null) {
            if (q.next.val == q.val) {
                flag = true;
                num = q.val;
                p = p.next;
                q = q.next;
            }
            if (flag) {
                while (q != null && q.val == num) {
                    p.next = q.next;
                    q = p.next;
                }
                flag = false;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}
