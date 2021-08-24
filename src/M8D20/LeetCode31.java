package M8D20;

import java.util.Arrays;

/**
 * 下一个排列
 * 例如 2, 6, 3, 5, 4, 1 这个排列，
 * 我们想要找到下一个刚好比他大的排列，
 * 于是可以从后往前看 我们先看后两位 4, 1 能否组成更大的排列，
 * 答案是不可以，同理 5, 4, 1也不可以
 * 直到3, 5, 4, 1这个排列，因为 3 < 5，
 * 我们可以通过重新排列这一段数字，来得到下一个排列
 * 因为我们需要使得新的排列尽量小，所以我们从后往前找第一个比3更大的数字，
 * 发现是4 然后，我们调换3和4的位置，得到4, 5, 3, 1这个数列
 * 因为我们需要使得新生成的数列尽量小，于是我们可以对5, 3, 1进行排序，
 * 可以发现在这个算法中，我们得到的末尾数字一定是倒序排列的，
 * 于是我们只需要把它反转即可 最终，我们得到了4, 1, 3, 5这个数列
 * 完整的数列则是2, 6, 4, 1, 3, 5
 */
public class LeetCode31 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,1,3,3};
//        int[] nums=new int[]{1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int pos=-1;
        for (int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                pos=i-1;
                break;
            }
        }
        //若不能找到下一个更大排列则重新排序
        if(pos==-1){
            Arrays.sort(nums);
            return;
        }

        int temp=nums[pos+1];
        int bigger=pos+1;
        //寻找pos后面比它大的最小数字进行交换
        //注意，若后面有相同的数字，优先使用后面的数，这样能让后面倒序时候满足小的在前面
        //否则用前面的数的话，回导致交换后依然存在1,2这样的情况
        for(int i=pos+2;i<nums.length;i++){
            if(nums[i]>nums[pos])
                if(nums[i]<=temp){
                    temp=nums[i];
                    bigger=i;
                }
        }
        temp=nums[pos];
        nums[pos]=nums[bigger];
        nums[bigger]=temp;
        //然后将pos后面的数字倒序即可
        int left=pos+1,right=nums.length-1;
        while (left<right){
            int a=nums[left];
            nums[left]=nums[right];
            nums[right]=a;
            left++;
            right--;
        }
    }
}
