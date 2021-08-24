package day01;

public class LeetCode35 {
    /**
     * 搜索插入位置
     * 第一种：由于数组时有序的，直接遍历直到发现大于等于target的时候直接返回即可，
     *      否则即该元素需要插入到末尾
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        //第一种o(n)
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target)
                return i;
        }
        return nums.length;
    }
    public int searchInsert2(int[] nums, int target) {
        //第二种用二分法,左闭右闭区间
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>target)
                r=mid-1;
            if(nums[mid]<target)
                l=mid+1;
            if(nums[mid]==target)
                return mid;
        }
        //查不到则返回r+1，因为此时r为小与target的第一个数
        return r+1;
    }
}
