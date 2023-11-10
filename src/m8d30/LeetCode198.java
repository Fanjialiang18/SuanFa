package m8d30;

/**
 * 打家劫舍
 *
 * @author clearlove3
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        //考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
        int[] dp = new int[n];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], nums[i - 1]);
        }
        return dp[n - 1];
    }
}
