package m8d24;

import java.util.Arrays;

/**
 * 寻找2个正序数组的中位数
 * 思路1：合并然后排序
 * 思路2：递归
 *  对K二分
 *  意思是我们需要分别在nums1和nums2中查找第K/2个元素
 *  注意这里由于两个数组的长度不定，所以有可能某个数组没有第K/2个数字，
 *  所以我们需要先检查一下，数组中到底存不存在第K/2个数字，如果存在就取出来，
 *  否则就赋值上一个整型最大值。如果某个数组没有第K/2个数字，
 *  那么我们就淘汰另一个数字的前K/2个数字即可。有没有可能两个数组都不存在第K/2个数字呢，
 *  这道题里是不可能的，因为我们的K不是任意给的，而是给的m+n的中间值，
 *  所以必定至少会有一个数组是存在第K/2个数字的。
 *  最后就是二分法的核心啦，比较这两个数组的第K/2小的数字midVal1和midVal2的大小，
 *  如果第一个数组的第K/2个数字小的话，那么说明我们要找的数字肯定不在nums1中的前K/2个数字
 *  所以我们可以将其淘汰，将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。
 *  反之，我们淘汰nums2中的前K/2个数字，并将nums2的起始位置向后移动K/2个，并且此时的K也自减去K/2，
 *  调用递归即可。
 */
public class LeetCode4 {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];//合并两个数组
        System.arraycopy(nums1, 0, temp, 0, nums1.length);
        System.arraycopy(nums2, 0, temp, nums1.length, nums2.length);
        Arrays.sort(temp);//重新排序
        double result = 0;
        result=(double) (temp[nums1.length+nums2.length+1]/2+temp[nums1.length+nums2.length+2]/2)/2;
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 在两个有序数组中找到第K个元素
     * @param nums1 数组1
     * @param i nums1的起始位置
     * @param nums2 数组2
     * @param j nums2的起始位置
     * @param k k
     * @return 找到的元素
     */
    private int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) {
            return nums2[j + k - 1];//nums1为空数组
        }
        if( j >= nums2.length) {
            return nums1[i + k - 1];//nums2为空数组
        }
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        //找k/2个数字，若找到则取出，否则附一个最大值
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            //说明不在nums1的前k/2个中，移动i
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            //说明不在nums2的前k/2个中，移动j
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }
}
