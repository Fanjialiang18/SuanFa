package shuzu;

/**
 * 删除有序数组中的重复项
 * 双指针
 * @author clearlove3
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int slow=0,fast=1;
        while (fast< nums.length){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
