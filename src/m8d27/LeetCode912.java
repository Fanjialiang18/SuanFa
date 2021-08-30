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
        int index=new Random().nextInt(right-left+1)+left;
        int temp=arr[left];
        arr[left]=arr[index];
        arr[index]=temp;
        temp=arr[left];
        while(left<right){
            while(left<right&&arr[right]>=arr[left]){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&arr[left]<=arr[left]){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=temp;
        return left;
    }
}
