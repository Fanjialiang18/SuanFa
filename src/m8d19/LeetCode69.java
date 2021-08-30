package m8d19;

/**
 * x的平方根
 * 思路：二分查找
 * 二分查找的下界为 0，上界可以粗略地设定为 x。
 * 在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，
 * 并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，不会存在误差，
 * 因此在得到最终的答案 ans 后，也就不需要再去尝试 ans+1 了。
 */
public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }
    public static int mySqrt(int x) {
        int l=0,r=x,ans=-1;
        while (l<=r){
            int mid=(r-l)/2+l;
            if((long)mid*mid<=x){
                ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }
}
