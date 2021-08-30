package day01;

/**
 * 搜索二维矩阵 II
 */
public class LeetCode240 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length-1,n=matrix[0].length,p=0;
        if(m==-1) {
            return false;
        }
        //右上角元素是这行的最大值，左下角元素是这列的最大值，若左下角大于目标，说明这行被去除
        //若左下角小鱼目标，则这列被去除
        while (m>=0&&p<n){
            if(matrix[m][p]>target) {
                m--;
            } else if (matrix[m][p]<target) {
                p++;
            } else {
                return true;
            }
        }
        return false;
    }
}
