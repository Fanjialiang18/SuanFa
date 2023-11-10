package day01;

public class LeetCode61 {
    public static ListNode rotateRight(ListNode head, int k) {
        //数组记录链表节点
        //重新构造
        if (k == 0 || head == null) {
            return head;
        }
        ListNode perr = new ListNode();
        ListNode[] nodelist = new ListNode[501];
        ListNode p = head;
        int i = 0;
        while (p != null) {
            nodelist[i] = p;
            p = p.next;
            i++;
        }
        k = k % i;
        if (k == 0) {
            return head;
        }
        nodelist[i - 1].next = head;
        nodelist[i - k - 1].next = null;
        perr.next = nodelist[i - k];
        return perr.next;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode();
        p.val = 1;
        ListNode q = new ListNode();
        q.val = 2;
        ListNode r = new ListNode();
        r.val = 3;
        ListNode s = new ListNode();
        s.val = 4;
        ListNode t = new ListNode();
        t.val = 5;
        ListNode u = new ListNode();
        u.val = 6;
        p.next = q;
        q.next = r;
        r.next = s;
        s.next = t;
        t.next = u;
        u.next = null;
        ListNode n = rotateRight(p, 4);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

}
