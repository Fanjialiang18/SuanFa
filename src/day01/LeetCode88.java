package day01;

import java.util.Arrays;

public class LeetCode88 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
    }

    /**
     * 合并2个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int j = 0, k = 0;
        for (int i = 0; i < temp.length; i++) {
            if (nums1[j] < nums2[k] && j < m) {
                temp[i] = nums1[j];
                j++;
            } else if (k < n) {
                temp[i] = nums2[k];
                k++;
            }
        }
        nums1 = Arrays.copyOf(temp, m + n);
        return nums1;


    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
        return nums1;
    }
}
