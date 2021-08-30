package m8d6;

import java.util.Stack;

/**
 * 用两个栈来实现队列
 * 一个处理输入
 * 一个处理输出
 * pop时即把输入栈的元素全部弹出然后压入输出栈即可得到先进先出
 */
public class LeetCode232 {

    class MyQueue{

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty()&&stack2.isEmpty();
        }
    }


}
