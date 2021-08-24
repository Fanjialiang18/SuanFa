package M8D24;

import java.util.Stack;

/**
 * 实现最小栈
 * 总是在最小值下存放一个次小值，弹最小值时会连同次小一起弹出。
 */
public class MinStack {
    private Node head;

    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    /*private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    *//** initialize your data structure here. *//*
    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int val) {
        if(min >= val){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.pop() .equals(min) ){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }*/
}
