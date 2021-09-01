package m9d2;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutation-i-lcci/
 * 无重复字符串的排列组合
 * dfs模板题，回溯，剪枝
 * @author clearlove3
 */
public class Mian0807 {
    /*private List<String> list = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] used = new boolean[10];
    public String[] permutation(String S) {
        dfs(S);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void dfs(String S) {
        if (path.length() == S.length()) {
            list.add(new String(path.toString()));
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (!used[i]) {
                path.append(S.charAt(i));
                used[i] = true;
                dfs(S);
                //回溯
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }*/
    private boolean[] used;
    /**
     如果字符串有重复字母，最简单的去重是使用Set，也可以排序后下标剪枝（相对比较难）
     重复字母的全排列可去做《全排列》系列题目。这道题好像和全排列I差不多。
     接着要做的就是回溯模板啦，选了的跳过，每次选或不选即可爆搜到所有解。
     */
    private List<String> res;
    private int len;

    public String[] permutation(String S) {
        len = S.length();
        used = new boolean[len];
        res = new ArrayList<>();

        dfs(S, new StringBuilder(), 0);

        return res.toArray(new String[0]);
    }

    private void dfs(String s, StringBuilder sb, int cnt) {
        // end —— 当sb长度与s长度一致时结束，存储答案
        if (cnt == len) {
            res.add(sb.toString());
            return;
        }

        // 回溯模板
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(s.charAt(i));
                dfs(s, sb, cnt + 1);
                used[i] = false;
                sb.deleteCharAt(cnt);
            }
        }
    }
}
