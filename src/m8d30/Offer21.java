package m8d30;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 思路：
 *  双指针
 * @author clearlove3
 */
public class Offer21 {
    public int[] exchange1(int[] nums) {
        //o(n)空间
        int[] res = new int[nums.length];
        int left=0,right= nums.length-1;
        for (int num : nums) {
            if ((num & 1) == 0) {
                res[right--] = num;
            } else {
                res[left++] = num;
            }
        }
        return res;
    }

    public int[] exchange(int[] nums) {
        //o(1)空间
        int left=0,right= nums.length-1;
        while (left<right){
            while (left<nums.length&&nums[left]%2!=0){
                left++;
            }
            while (right>=0&&nums[right]%2==0){
                right--;
            }
            if(left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        return nums;
    }
}
