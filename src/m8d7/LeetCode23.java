package m8d7;

import day01.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 * 思路1：使用最小优先队列
 *      最小优先队列的底层实现：二叉堆，每次操作的复杂度为logn
 *      用容量为K的最小堆优先队列，把链表的头结点都放进去，
 *      然后出队当前优先队列中最小的，挂上链表，
 *      然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
 *
 * 思路2：分治
 *      递归二分分治合并
 */
public class LeetCode23 {
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0) {
            return null;
        }
        ListNode dummyNode=new ListNode(-1);
        ListNode cur=dummyNode;
        //维护一个最小优先队列
        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode list:lists){
            if(list==null) {
                continue;
            }
            priorityQueue.add(list);
        }
        while (!priorityQueue.isEmpty()){
            ListNode next=priorityQueue.poll();
            cur.next=next;
            cur=cur.next;
            if(next.next!=null) {
                priorityQueue.add(next.next);
            }

        }
        return dummyNode.next;
    }
    //分治
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists,int left,int right){
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    //逐次合并两个有序链表
    //非递归会超时
    //递归会栈溢出。。
    //改进：二分递归
    public ListNode mergeKLists3(ListNode[] lists) {
        if(lists.length==0) {
            return null;
        }
        ListNode res=lists[0];
        for(ListNode node:lists){
            res=mergeTwoLists(res,node);
        }
        return res;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
