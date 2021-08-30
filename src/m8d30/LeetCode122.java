package m8d30;

/**
 * 买卖股票的最佳时机
 * 贪心：
 *  只要今天价格小于明天价格就在今天买入然后明天卖出
 * DP:
 *  dp[i][0]表示第i天不持有股票, dp[i][1]表示第i天持有股票
 * @author clearlove3
 */
public class LeetCode122 {
    /**
     * 贪心法
     */
    public int maxProfit1(int[] prices) {
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            res+=Math.max(0,prices[i]-prices[i-1]);
        }
        return res;
    }

    /**
     * 方法二：动态规划
     * 不能同时参与多笔交易，所以每天交易结束只有持有一只股票和没有股票两种状态
     * 我们使用dp[i][0] 表示第i天交易完成后没有持股的最大利润，dp[i][1] 表示第i天交易完成后持股的最大利润.
     * 第一种dp[i][0]，说明第i天没有持股，此时有两种可能，第i-1天没有持股，然后今天也没有买入交易，则利润为dp[i-1][0]，或者第i-1天持有股票，在今天卖出，利润为dp[i-1][1]+prices[i];
     * 所以dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
     *
     * 第二种情况dp[i][1],说明第i天持有股票，此时有两种可能，第i-1天就持有股票，今天保持不动没有交易，则利润为dp[i-1][1],或者第i-1天没有持股，是在今天买入了一支股票,则利润为dp[i-1][0] - prices[i];
     * 所以dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
     *
     * 观察两种情况我们发现我们今天的利润只和前一天相关，我们需要记录前一天的利润。
     * 那么对于第一天来说dp[0][0] = 0,dp[0][1] = -prices[0]因为第一天利润为0，花钱买入所以为负值
     * 那么最后一天dp[n][0],dp[n][1]则肯定是全部卖出不持股钱最多。
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp0代表前一天不持股票的利润，dp1代表前一天持股票的利润，这里用第0天初始化
        int dp0 = 0 , dp1 = -prices[0];
        for(int i = 1;i<n;i++){
            dp0 = Math.max(dp0,dp1+prices[i]);
            dp1 = Math.max(dp1,dp0-prices[i]);
        }
        return dp0;
    }
}
