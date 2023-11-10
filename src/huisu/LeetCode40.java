package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 需要用一个数组记录某个数是否被用过从而保证该层不重复选取
 *
 * @author clearlove3
 */
public class LeetCode40 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracks(candidates, target, 0);
        return res;
    }

    private void backTracks(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTracks(candidates, target, i + 1);
            sum -= path.get(path.size() - 1);
            path.remove(path.size() - 1);
        }
    }
}
