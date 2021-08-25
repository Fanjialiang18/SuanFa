package M8D25;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 回溯，多看
 * 思路1：
 *  DFS+少量的剪枝
 * 思路2：
 *  回溯
 *
 */
public class LeetCode22 {
    List<String> res = new ArrayList<>();
    StringBuilder ans=new StringBuilder();
    //思路1
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
    //思路2
    public List<String> generateParenthesis2(int n) {
        backTrack(n, n);
        return res;
    }

    private void backTrack(int l,int r){
        if(l==0&&r==0)
            res.add(ans.toString());
        if(l!=0){
            ans.append('(');
            backTrack(l-1,r);
            ans.deleteCharAt(ans.length()-1);
        }
        if(r>l){
            ans.append(')');
            backTrack(l,r-1);
            ans.deleteCharAt(ans.length()-1);
        }
    }
}
