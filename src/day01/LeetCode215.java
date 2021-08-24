package day01;

import java.util.Arrays;

public class LeetCode215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1,2,3,4,5},2));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
