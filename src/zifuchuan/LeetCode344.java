package zifuchuan;

/**
 * 反转字符串
 *
 * @author clearlove3
 */
public class LeetCode344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
