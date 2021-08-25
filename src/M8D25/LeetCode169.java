package M8D25;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 思路：
 *  摩尔投票法
 *  摩尔投票法,先假设第一个数过半数并设cnt=1；
 *  遍历后面的数如果相同则cnt+1，不同则减一，
 *  当cnt为0时则更换新的数字为候选数
 *  （成立前提：有出现次数大于n/2的数存在）
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int count=0,flag=0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                flag=nums[i];
            }
            if(nums[i]==flag)
                count++;
            else
                count--;

        }
        return flag;
    }
}
