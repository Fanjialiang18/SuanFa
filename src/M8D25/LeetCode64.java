package M8D25;

/**
 * 最小路径和
 * DP，多看
 * 思路：
 *  dp[i][j]表示从0,0走到i,j的最短路径和
 *  则到i,j的路径可以是从i-1,j走一格i和从i,j-1走一格到的最小值
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        //dp[i][j]表示从0,0走到i,j的最短路径和
        int[][] dp=new int[grid.length][grid[0].length];
        int m=grid.length,n=grid[0].length;
        dp[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
