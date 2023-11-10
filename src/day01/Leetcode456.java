package day01;

import java.util.Stack;

public class Leetcode456 {
    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int num2 = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < num2) {
                return true;
            }
            //维护一个递减栈
            //num2是比num3小的最大值
            while (!s.isEmpty() && s.peek() < nums[i]) {
                num2 = s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 0};
        System.out.println(find132pattern(nums));
    }

}
