package zifuchuan;

/**
 * 反转字符串 II
 * 每 2k 个字符反转前 k 个字符。
 * 就让i指针每次移动2k个即可
 * @author clearlove3
 */
public class LeetCode541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k) {
            int left=i;
            //判断尾数够不够k个来取决右指针的位置
            int right=Math.min(chars.length-1,left+k-1);
            while (left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
