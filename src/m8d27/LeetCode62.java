package m8d27;

/**
 * 不同路径
 * 盲猜DP
 * 猜对了！
 * 第一自己写的dp。。。
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示从起点到ij的路径数目
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for (int i = 1; i < m; i++) {
            dp[i][0]=dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i]=dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
