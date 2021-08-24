package M8D24;

import java.util.Arrays;

/**
 * 寻找2个正序数组的中位数
 *
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
}
