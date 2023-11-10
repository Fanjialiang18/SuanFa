package zhanheduilie;

import java.util.Stack;

/**
 * 删除字符串中的所有相邻重复项
 * 思路：
 * 用栈，遇到相同的就消除，否则进栈
 *
 * @author clearlove3
 */
public class LeetCode1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
