package dp.Pack0_1;

/**
 * 组合成i的方式
 * @author clearlove3
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if((target+sum)%2!=0){
            return 0;
        }
        int size=Math.abs((target+sum)/2);
        //dp[i]表示组合成i的方法数
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
