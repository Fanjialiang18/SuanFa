package day01;

import java.util.Stack;

public class LeetCode20 {
    /**
     * 有效的括号
     * 思路是遍历各个字符，将其对应的右括号入栈，然后右括号逐次匹配，判断是否是有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //思路是遍历各个字符，将其对应的右括号入栈，然后右括号逐次匹配，判断是否是有效的括号
        Stack<Character> characters=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(') {
                characters.push(')');
            } else if(c=='[') {
                characters.push(']');
            } else if(c=='{') {
                characters.push('}');
            } else if(characters.isEmpty()||c!=characters.pop()) {
                return false;
            }
        }
        return characters.isEmpty();
    }
}
