package day01;

public class LeetCode121 {
    /**
     * 买卖股票的最佳时机
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit=0;
        int t=prices[0];
        for (int price : prices) {
            //更新最大盈利
            if (price - t > profit) {
                profit = price - t;
            } else if (price - t < 0) {//此时后面的值小与买入值，更新买入时机
                t = price;
            }
        }
        return profit;
    }
}
