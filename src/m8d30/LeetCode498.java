package m8d30;

/**
 * 对角线遍历
 * 思路：
 * 遍历方向由层数决定，而层数即为横纵坐标之和
 *
 * @author clearlove3
 */
public class LeetCode498 {
    public static void main(String[] args) {
        int[] diagonalOrder = findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0;
        for (int i = 0; i < m * n; i++) {
            res[i] = mat[row][col];
            // row + col 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((row + col) % 2 == 0) {
                if (col == n - 1) {
                    // 遍历到头往下移动一格准备向下遍历
                    row++;
                } else if (row == 0) {
                    // 遍历到头往右移动一格准备向下遍历
                    col++;
                } else {
                    // 遍历中往上移动
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    // 遍历到头往右移动一格准备向上遍历
                    col++;
                } else if (col == 0) {
                    // 遍历到头往下移动一格准备向上遍历
                    row++;
                } else {
                    // 遍历中往下移动
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}
