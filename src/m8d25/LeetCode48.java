package m8d25;

/**
 * 旋转图像
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。
 * 请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，
 * 这意味着你需要直接修改输入的二维矩阵。
 * 请不要 使用另一个矩阵来旋转图像。
 * 思路:
 * 情况一：顺时针转 90 度：先转置再左右镜像
 * 1 2 3               7 4 1
 * 4 5 6               8 5 2
 * 7 8 9               9 6 3
 * 情况二：顺时针转 180 度:先上下镜像，再左右镜像（先左右再上下也可）
 * 1 2 3               9 8 7
 * 4 5 6               6 5 4
 * 7 8 9               3 2 1
 * 情况三：顺时针转 270 度：先转置再上下镜像
 * 1 2 3              3 6 9
 * 4 5 6              2 5 8
 * 7 8 9              1 4 7
 */
public class LeetCode48 {
    /**
     * 先转置再镜像
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //镜像
        int left = 0, right = n - 1;
        while (left < right) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }
}
