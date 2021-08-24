package day01;

import java.util.Arrays;
import java.util.Random;

public class LeetCode215_2 {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int index=partition(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    public static int partition(int[] arr,int low,int high){
        int index=new Random().nextInt(high-low+1)+low;
        int i=arr[low];
        arr[low]=arr[index];
        arr[index]=i;
        int temp=arr[low];
        while(low<high){
            while(low<high&&arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while(low<high&&arr[low]<=temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,2,1,5,6,4};
        quickSort(a,0,5);
        System.out.println(Arrays.toString(a));
    }
}
