package m8d5;

public class LeetCode33 {
    /**
     * 搜索旋转排序数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //首先找翻转的位置
        int k = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i + 1;
                break;
            }
        }
        //然后用二分即可,确定一下区间
        int left, right;
        if (nums[0] > target) {
            if (nums[k] > target) {
                return -1;
            }
            left = k;
            right = nums.length - 1;
        } else {
            left = 0;
            right=k==0?nums.length-1:k-1;
        }
        while (left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]>target) {
                right=middle-1;
            }
            if(nums[middle]<target) {
                left=middle+1;
            }
            if(nums[middle]==target) {
                return middle;
            }
        }
        return -1;
    }
}
