package shuzu;

/**
 * 比较含退格的字符串
 * 双指针，分别处理两个字符，然后调用equals方法
 *
 * @author clearlove3
 */
public class LeetCode844 {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("aaa#cc", "aacc"));
    }

    public static boolean backspaceCompare(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int w1 = 0, r1 = 0, w2 = 0, r2 = 0;
        while (r1 < s.length()) {
            if (ss[r1] == '#') {
                if (w1 > 0) {
                    w1--;

                }
            } else {
                ss[w1] = ss[r1];
                w1++;

            }
            r1++;
        }
        String res1 = new String(ss, 0, w1);
        while (r2 < t.length()) {
            if (tt[r2] == '#') {
                if (w2 > 0) {
                    w2--;

                }
            } else {
                tt[w2] = tt[r2];
                w2++;

            }
            r2++;
        }
        String res2 = new String(tt, 0, w2);
        return res1.equals(res2);
    }
}
