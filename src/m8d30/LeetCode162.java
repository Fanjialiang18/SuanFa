package m8d30;

/**
 * 寻找峰值
 * 思路1：
 * 3指针法log(n)
 * 思路2：
 * 二分
 * 如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
 * 如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
 */
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
