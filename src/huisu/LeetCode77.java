package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 回溯
 *
 * @author clearlove3
 */
public class LeetCode77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1);
        return res;
    }

    private void helper(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            helper(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
