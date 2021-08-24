package M8D20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 思路：贪心，局部最优解合并
 * 先按照左区间进行排序，然后进行合并即可
 */
public class LeetCode56 {
    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8,10},{15,18}});
//        int[][] merge = merge(new int[][]{{1, 4},{4,5}});
        for(int[] res:merge){
            System.out.println(Arrays.toString(res));
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        //先按照左区间进行排序
        Arrays.sort(intervals,((o1, o2) ->
            Integer.compare(o1[0],o2[0])
        ));
        int start=intervals[0][0];
        for (int i = 0; i < intervals.length-1; i++) {
            if(intervals[i][1]>=intervals[i+1][0]){//前者的右区间大于后者的左区间则可以合并
                intervals[i+1][1]=Math.max(intervals[i][1],intervals[i+1][1]);
            }else {//否则继续比较
                res.add(new int[]{start,intervals[i][1]});
                start=intervals[i+1][0];
            }
        }
        res.add(new int[]{start,intervals[intervals.length-1][1]});
        return res.toArray(new int[res.size()][]);
    }
}
