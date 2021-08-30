package m8d5;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        System.out.println(list);
    }
    /**
     * 螺旋矩阵
     * 思路：分为上下左右进行添加即可
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int cols=matrix[0].length,rows=matrix.length;
        int direct=1;
        int times=0;
        List<Integer> res=new ArrayList<>();
        while (res.size()!=cols*rows){
            switch (direct){
                case 1:
//                    res.addAll(matrix[row]);
                    //横向从左到右
                    for(int i=times;i<cols-times;i++){
                        res.add(matrix[times][i]);
                    }
                    direct++;
                    break;
                case 2:
                    //从上到下
                    for (int i = times+1; i < rows-times; i++) {
                        res.add(matrix[i][cols-times-1]);
                    }
                    direct++;
                    break;
                case 3:
                    //从右到左
                    for(int i=cols-times-2;i>times-1;i--){
                        res.add(matrix[rows-1-times][i]);
                    }
                    direct++;
                    break;
                case 4:
                    //从下到上
                    for(int i=rows-times-2;i>times;i--){
                        res.add(matrix[i][times]);
                    }
                    direct=1;
                    times++;
                    break;
                default:
            }
        }
        return res;
    }

}
