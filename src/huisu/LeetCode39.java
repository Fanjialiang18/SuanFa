package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author clearlove3
 */
public class LeetCode39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 先进行排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            // 回溯，移除路径 path 最后一个元素
            path.remove(path.size() - 1);
        }
    }
}
