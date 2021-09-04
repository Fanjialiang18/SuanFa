package shuzu;

/**
 * 长度最小的子数组
 * 滑动窗口
 * @author clearlove3
 */
public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE,sum=0;
        int l=0,r=0;
        for(;r< nums.length;r++){
            sum+=nums[r];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum>=target){
                res=Math.min(res,r-l+1);
                // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
                sum-=nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
