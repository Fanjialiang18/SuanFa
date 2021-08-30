package m8d24;

/**
 * 缺失的第一个正数
 * 思路很巧
 * 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
 * 然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，
 * 否则遍历完都没出现那么答案就是数组长度加1。
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++)
        {
            //小心[1,1]出现死循环
            while (nums[i] < nums.length
                    && nums[i] > 0
                    && nums[i] != i + 1
                    && nums[i] != nums[nums[i] - 1]
                    )
            {//将nums[i]放到对应的位置上，交换位置
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
