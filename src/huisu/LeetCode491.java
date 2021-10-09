package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增子序列
 * @author clearlove3
 */
public class LeetCode491 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length<2){
            return res;
        }
        helper(nums,0);
        return res;
    }

    private void helper(int[] nums,int start){
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        //使用该数组来去重
        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            helper(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
