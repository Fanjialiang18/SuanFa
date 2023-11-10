package day01;

import java.util.*;

public class LeetCode15 {
/*
给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

 */

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum2(new int[]{0, 0, 0});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 暴力求解法
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return new ArrayList<List<Integer>>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            map.clear();
            target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    set.add(Arrays.asList(nums[i], map.get(nums[j]), nums[j]));
                }
                map.put(target - nums[j], nums[j]);
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 双指针法，一开始通过set去重，效率低
     * 后来发现可以手动移动l和r来去重
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int result = nums[i] + nums[left] + nums[right];
                if (result > 0) {
                    right--;
                }
                if (result < 0) {
                    left++;
                }
                if (result == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }
}
