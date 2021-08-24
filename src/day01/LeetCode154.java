package day01;

public class LeetCode154 {
    public static void main(String[] args) {

    }
    public static int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=(r-l)/2+l;
            if(nums[mid]>nums[r])
                l=mid+1;
            else if(nums[mid]<nums[r])
                r=mid;
            else
                r=r-1;
        }
        return nums[l];
    }
}
