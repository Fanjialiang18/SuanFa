package dp.fullPack;

/**
 * 求排列数目
 * 排列则外层背包
 * 组合则外层物品
 *
 * @author clearlove3
 */
public class LeetCode377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
