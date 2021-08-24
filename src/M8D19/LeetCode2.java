package M8D19;

import day01.ListNode;


/**
 * 两数相加
 * 逐个相加即可
 * 注意，链表类题目一般需要创建一个冗余头结点
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode p=res;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){
            int a=l1==null?0:l1.val;
            int b=l2==null?0:l2.val;
            int sum=a+b+carry;
            carry=sum/10;
            p.next= new ListNode(sum%10);
            p=p.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        return res.next;
    }
}
