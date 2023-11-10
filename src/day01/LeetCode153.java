package day01;

/**
 * 寻找旋转排序数组中的最小值
 */
public class LeetCode153 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 0, 1, 2, 3}));
    }

    public static int findMin(int[] nums) {
        //使用二分查找
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
