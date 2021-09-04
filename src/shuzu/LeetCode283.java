package shuzu;

/**
 * 移动0
 * 双指针
 *
 * @author clearlove3
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        //将非0移到前面
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        //后面填充0
        while (slow< nums.length){
            nums[slow]=0;
            slow++;
        }
    }
}
