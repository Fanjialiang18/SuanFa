package M8D25;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 复杂度logN,二分找左边界，然后找右边界
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        //用左闭右闭
        int l=0,r=nums.length-1,mid=0;
        while (l<=r){
            mid=l+(r-l)/2;
            if(nums[mid]>target)
                r=mid-1;
            else if(nums[mid]<target)
                l=mid+1;
            else{
                res[0]=mid;
                //因为要找到左边界，需要继续往左找
                r=mid-1;
            }
        }
        if(res[0]==-1)
            return res;
        l=0;
        r=nums.length-1;
        while (l<=r){
            mid=l+(r-l)/2;
            if(nums[mid]>target)
                r=mid-1;
            else if(nums[mid]<target)
                l=mid+1;
            else{
                res[1]=mid;
                //因为要找到右边界，需要继续往右找
                l=mid+1;
            }
        }
        return res;
    }
}
