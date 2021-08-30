package m8d25;

import java.util.Arrays;

/**
 * 零钱兑换
 * DP，多看
 * 得到dp[j]（考虑coins[i]），只有一个来源，dp[j - coins[i]]（没有考虑coins[i]）。
 * 凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，
 * 那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
 * 所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最小的。
 * 递推公式：dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        //dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        Arrays.fill(dp, max);
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {// 遍历物品
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {// 遍历背包
                // 如果dp[j - coins[i]]是初始值则跳过
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
