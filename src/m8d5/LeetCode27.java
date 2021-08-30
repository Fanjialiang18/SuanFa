package m8d5;

public class LeetCode27 {
    /**
     * 删除数组元素，返回删除后的数组元素大小
     * 思路1：双层for循环遍历
     * 思路2：快慢指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow=0,fast=0;
        while (fast<nums.length){
            if(nums[fast]!=val){
                //当fast等于要删除的值时候，slow不动，fast后移，此时slow等于要删除的，
                //fast一直移动到不相等的时候，之后开始逐个代替即可
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
