package m8d26;

/**
 * 最大正方形
 * DP
 */
public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        /*
         dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
         dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
         */
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0, up = 0, leftUp = 0;
                if (0 <= j - 1) {
                    left = dp[i][j - 1];
                }
                if (i - 1 >= 0) {
                    up = dp[i - 1][j];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    leftUp = dp[i - 1][j - 1];
                }
                int min = Math.min(up, left);
                min = Math.min(min, leftUp);
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + min;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
