package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 *
 * @author clearlove3
 */
public class LeetCode216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1);
        return res;
    }

    private void helper(int k, int n, int start) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            helper(k, n, i + 1);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
