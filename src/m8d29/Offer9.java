package m8d29;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 和LeetCode232一样
 */
public class Offer9 {
    class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public CQueue() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack2.isEmpty()){
                if(stack1.isEmpty()) {
                    return -1;
                }
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
