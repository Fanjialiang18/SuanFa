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
        int base=arr[low];
        while(low<high){
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while(low<high&&arr[high]>=base){
                high--;
            }
            // 如果队尾元素小于base了,需要将其赋值给low
            arr[low]=arr[high];
            while(low<high&&arr[low]<=base){
                low++;
            }
            // 当队首元素大于base时,需要将其赋值给high
            arr[high]=arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是base,所以需要将base赋值给arr[low]
        arr[low]=base;
        return low;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,2,1,5,6,4};
        quickSort(a,0,5);
        System.out.println(Arrays.toString(a));
    }
}
