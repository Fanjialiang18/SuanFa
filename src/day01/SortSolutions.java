package day01;

import java.util.Arrays;

public class SortSolutions {


    public static void main(String[] args) {
        BubbleSort(new int[]{2,1,9,5});
        InsertSort(new int[]{2,1,9,5});
        SelectSort(new int[]{2,1,9,5});
        System.out.println(Arrays.toString(MergeSort(new int[]{2,1,9,5})));
        System.out.println(Arrays.toString(QuickSort(new int[]{2,1,9,5})));
    }

    public static void BubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j]>nums[j+1]){
                    nums[j]=nums[j]+nums[j+1];
                    nums[j+1]=nums[j]-nums[j+1];
                    nums[j]=nums[j]-nums[j+1];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void InsertSort(int[] nums){
        int n=nums.length;
        int pre,cur;
        for (int i = 1; i < n; i++) {
            pre=i-1;
            cur=nums[i];
            while (pre>=0&&cur<nums[pre]){
                nums[pre+1]=nums[pre];
                pre--;
            }
            nums[pre+1]=cur;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void SelectSort(int[] nums){
        int max=0;//记录最大值的下标
        for (int i = 0; i < nums.length; i++) {
            max=i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[max]<nums[j]){
                    max=j;
                }
            }
            int temp=nums[i];//将最大值放到前面去
            nums[i]=nums[max];
            nums[max]=temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int[] MergeSort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle =arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(MergeSort(left), MergeSort(right));
    }

    protected static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    public static int[] QuickSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int random = (int)Math.random()*arr.length;
        int temp;
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        temp = arr[left];
        arr[left] = arr[index - 1];
        arr[index - 1] = temp;
        return index - 1;
    }
}
