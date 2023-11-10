package linklist;

import day01.ListNode;

/**
 * 面试题 02.07. 链表相交
 *
 * @author clearlove3
 */
public class MianShi0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        // 求链表A的长度
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        // 求链表B的长度
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        //让curA和curB在同一起点上（末尾位置对齐）
        if (lenA >= lenB) {
            int gap = lenA - lenB;
            while (gap-- > 0) {
                curA = curA.next;
            }
        } else {
            int gap = lenB - lenA;
            while (gap-- > 0) {
                curB = curB.next;
            }
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
