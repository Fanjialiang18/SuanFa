package m8d6;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 原来思路错误：因为不需要是连续
 * 正确思路：动态规划
 */
public class LeetCode300 {
    public static void main(String[] args) {
//        int i = lengthOfLIS(new int[]{1, 2, 3, 4, 5, 2, 1, 2, 1});
        int i = lengthOfLIS(new int[]{1, 1});
        System.out.println(i);
    }

    public static int lengthOfLIS_Wrong(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 0;
            }
        }
        return max == 0 ? 1 : max;
    }

    public static int lengthOfLIS(int[] nums) {
        //dp[i]储存从0到i的最长递增子序列长度，初始化为1
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //从0到i-1，dp[i]取原来dp[i]和dp[j]+1的最大值
        //前提是nums[i]>nums[j]，这时候子序列可以增长
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] > res) {
                    res = dp[i];
                }
            }
        }
        return res;
    }

}
