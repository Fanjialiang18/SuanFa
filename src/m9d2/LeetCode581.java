package m9d2;

/**
 * 最短连续子数组
 * 思路：
 *  如果最右端的一部分已经排好序，这部分的每个数都比它左边的最大值要大，
 *  同理，如果最左端的一部分排好序，这每个数都比它右边的最小值小。
 *  所以我们从左往右遍历，如果i位置上的数比它左边部分最大值小，则这个数肯定要排序，
 *  就这样找到右端不用排序的部分，同理找到左端不用排序的部分，它们之间就是需要排序的部分
 * @author clearlove3
 */
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int l=0,r=0;
        for (int i = 0; i < nums.length; i++) {
            if(max>nums[i]){
                r=i;
            }else {
                max=nums[i];
            }
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            if(min<nums[i]){
                l=i;
            }else {
                min=nums[i];
            }
        }
        return l==r?0:r-l+1;
    }
}
