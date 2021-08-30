package m8d27;

/**
 * 移动0
 * 思路：
 *  快慢指针
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int slow=0,fast=0;
        //快指针将不是0的数移到前面
        for(;fast<nums.length;fast++){
            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        //慢指针将后面的数置为0
        for(;slow<nums.length;slow++){
            nums[slow]=0;
        }
    }
}
