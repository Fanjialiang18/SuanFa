package zifuchuan;

/**
 * 左旋转字符串
 * 思路1：
 * 用额外空间，简单，从左到右
 * 思路2：
 * 不用额外空间，局部反转加全局翻转即可
 *
 * @author clearlove3
 */
public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n - 1);
        reverse(sb, n, sb.length() - 1);
        return sb.reverse().toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
