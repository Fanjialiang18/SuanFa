package day01;

import java.util.List;

public class LeetCode21 {
    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(4);
        ListNode b1=new ListNode(1);
        ListNode b2=new ListNode(3);
        ListNode b3=new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=null;
        b1.next=b2;
        b2.next=b3;
        b3.next=null;

        ListNode listNode = mergeTwoLists(a1, b1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head;
        if(l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }else{
            head=l2;
            l2=l2.next;
        }
        ListNode result=head;
        while (true){
            if(l1==null){
                head.next=l2;
                l2=l2.next;
            }else if(l2==null){
                head.next=l1;
                l1=l1.next;
            }else if(l1.val< l2.val){
                head.next=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            if(l1==null&&l2==null)
                break;
            head=head.next;
        }
        return result;
    }
}
