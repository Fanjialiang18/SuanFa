package m8d26;

import java.util.Stack;

/**
 * 最长有效括号
 * 格式正确且连续
 * 思路1：
 *  用栈
 * 思路2：
 *  DP
 */
public class LeetCode32 {
    public static void main(String[] args) {
        longestValidParentheses1("()))()()");
    }
    /**
     * 用栈
     */
    public static int longestValidParentheses1(String s) {
        int res=0;
        Stack<Integer> stack=new Stack<>();
        //用于计算初始长度的数
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            //每次遇到一个左括号，则把左括号的下标入栈；
            if(c=='(') {
                stack.push(i);
            } else {
                //每次遇到一个右括号，则先把栈顶的元素弹出，
                stack.pop();
                //如果弹出后当前栈变成空栈，则需要将当前右括号所在位置入栈
                //因为下一个的有效长度需要从这里开始算
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                //否则需要根据当前栈顶元素和当前右括号下标计算当前有效括号子串的长度，更新res
                else {
                    res=Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        //定义数组dp，长度和输入的s保持一致，dp[i]保持是以s[i]结尾的最长有效子串的长度
        int[] dp=new int[s.length()];
        int res=0;
        for (int i = 1; i < s.length(); i++) {
            char c=s.charAt(i);
            //当遇到右括号时，尝试向前匹配左括号
            if (c == ')'){
                //pre为有效的之前的下标
                int pre = i - dp[i-1] -1;
                //如果是左括号，则更新匹配长度
                if (pre>=0 && s.charAt(pre) == '('){
                    dp[i] = dp[i-1] + 2;
                    //处理独立的括号对的情形 类似()()、()(())
                    if (pre>0){
                        //此时pre对应的为无效的
                        dp[i] += dp[pre-1];
                    }
                    res=Math.max(res,dp[i]);
                }
            }
        }
        return res;
    }
}
