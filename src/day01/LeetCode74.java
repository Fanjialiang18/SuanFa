package day01;

public class LeetCode74 {
    //将二维数组转化为一维数组即可
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) {
            return false;
        }
        int right=matrix.length*matrix[0].length-1,n=matrix[0].length;
        int mid=0,left=0;
        while (left<=right){
            mid=left+(right-left)/2;
            if(matrix[mid/n][mid%n]>target){
                right=mid-1;
            }else if(matrix[mid/n][mid%n]<target){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
