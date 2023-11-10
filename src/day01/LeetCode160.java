package day01;

public class LeetCode160 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        a1.next = a2;
        a2.next = null;
        b1.next = b2;
        b2.next = b3;
        b3.next = null;
        ListNode intersectionNode = getIntersectionNode(a1, b1);
        System.out.println(intersectionNode.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode you = headA, she = headB;
        while (you != she) { // 若是有缘，你们早晚会相遇
            you = you != null ? you.next : headB; // 当你走到终点时，开始走她走过的路
            she = she != null ? she.next : headA; // 当她走到终点时，开始走你走过的路
        }
        // 如果你们喜欢彼此，请携手一起走完剩下的旅程（将下面这个 while 块取消注释）。
        // 一路上，时而你踩着她的影子，时而她踩着你的影子。渐渐地，你变成了她，她也变
        // 成了你。
        /* while (she) {
            you = she->next;
            she = you->next;
        } */
        return you;
    }
}
