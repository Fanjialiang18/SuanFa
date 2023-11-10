package m8d27;

import java.util.Random;

/**
 * 排序数组
 * 快排
 */
public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    public int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int index = new Random().nextInt(right - left + 1) + left;
        int temp = arr[left];
        arr[left] = arr[index];
        arr[index] = temp;
        //基准
        temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    /**
     * 堆排序 - 堆排序的思想借助于二叉堆中的最大堆得以实现。
     * 首先，将待排序数列抽象为二叉树，并构造出最大堆；
     * 然后，依次将最大元素（即根节点元素）
     * 与待排序数列的最后一个元素交换（即二叉树最深层最右边的叶子结点元素）；
     * 每次遍历，刷新最后一个元素的位置（自减1），
     * 直至其与首元素相交，即完成排序。
     * <p>
     * 时间复杂度：O(NlogN) 　　稳定性：不稳定
     */
    void heapSort(int[] nums) {
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjust(nums, size, i);
        }
        for (int i = size - 1; i >= 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums, i, 0);
        }
    }

    void adjust(int[] nums, int len, int index) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        int maxIndex = index;
        if (l < len && nums[l] > nums[maxIndex]) {
            maxIndex = l;
        }
        if (r < len && nums[r] > nums[maxIndex]) {
            maxIndex = r;
        }
        if (maxIndex != index) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[index];
            nums[index] = temp;
            adjust(nums, len, maxIndex);
        }
    }
}
