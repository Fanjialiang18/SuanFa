package shuzu;

/**
 * 二分搜索
 * 使用左闭右闭区间
 * @author clearlove3
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int l=0,r= nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>target){
                r=mid-1;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
