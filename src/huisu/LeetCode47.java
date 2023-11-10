package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author clearlove3
 */
public class LeetCode47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums);
        return res;
    }

    private void helper(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                helper(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
