package day01;

/**
 * 删除排序链表中的重复元素 II
 * 思路：遍历，然后删除
 */
public class LeetCode82 {
    public ListNode numeteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        boolean flag = false;  //标记数是否需要被删除
        int num=-101;    //需要删除的数
        ListNode p = dummy,q = head;
        while(q!=null && q.next!=null){
            if(q.next.val == q.val){
                flag = true;
                num = q.val;
            }
            if(flag){
                //删除后面所有相同的数
                while(q!=null && q.val == num){
                    p.next = q.next;
                    q = p.next;
                }
                flag = false;
            }
            else{
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}
