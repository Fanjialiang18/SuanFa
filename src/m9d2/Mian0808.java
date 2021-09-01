package m9d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-ii-lcci/
 * 有重复字符串的排列组合
 * @author clearlove3
 */
public class Mian0808 {
    /**
     * 动态数组存储排列结果
     */
    private List<String> res = new ArrayList<>();
    /**
     * 构建每次排列的字符串
     */
    StringBuilder path = new StringBuilder();
    public String[] permutation(String S) {
        char[] c = S.toCharArray();
        //面对有重复元素的排列问题，核心步骤是排序
        Arrays.sort(c);
        int len = c.length;
        //避免重复访问
        boolean[] used = new boolean[len];
        backtracking(c,used);
        String[] ans = new String[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    /**
     * 回溯算法
     */
    private void backtracking(char[] c,boolean[] used){
        //递归返回条件
        if(path.length()==c.length){
            res.add(path.toString());
            return;
        }
        for(int i=0;i<c.length;i++){
            if(used[i]){
                continue;
            }
            //剪枝，排除重复元素带来的重复排列比如 q(1)q(2)e，q(2)q(1)e这种。
            if(i>0 && c[i]==c[i-1] && !used[i-1]){
                continue;
            }
            path.append(c[i]);
            used[i] = true;
            backtracking(c,used);
            //状态重置
            used[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
}
