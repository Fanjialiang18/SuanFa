package m8d25;

/**
 * 只出现一次的数字
 * 异或
 * 注意：不需要额外空间的方法，就往位运算上想
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int a=0;
        for (int i = 0; i < nums.length; i++) {
            a=a^nums[i];
        }
        return a;
    }
}
