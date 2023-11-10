package shuzu;

/**
 * 移除元素
 * 双指针法
 *
 * @author clearlove3
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
