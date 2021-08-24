package day01;

public class LeetCode704 {
    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //左闭右闭区间
        int left=0;
        int right=nums.length-1;
        //条件为小于等于
        while(left<=right){
            //中值
            int mid=left+(right-left)/2;
            if(nums[mid]>target)
                right=mid-1;
            else if(nums[mid]<target)
                left=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
