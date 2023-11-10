package zifuchuan;

/**
 * 重复的子字符串
 *
 * @author clearlove3
 */
public class LeetCode459 {
    /**
     * 假设给定字符串s可由一个子串x重复n次构成，即s=nx。
     * 现构造新字符串t=2s，即两个s相加，由于s=nx，则t=2nx。
     * 去掉t的开头与结尾两位，则这两处的子串被破坏掉，此时t中包含2n-2个子串。
     * 由于t中包含2n-2个子串，s中包含n个子串，若t中包含s，则有2n-2>=n，
     * 可得n>=2，由此我们可知字符串s可由一个子串x重复至少2次构成，判定为true；
     * 反之，若t中不包含s，则有2n-2<n，可得n<2，n只能为1
     * 由此我们可知字符串s=x，假定的子串就为s本身，判定为false。
     */
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        ss = ss.substring(1, ss.length() - 1);
        return ss.contains(s);
    }

    /**
     * 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，
     * 如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
     */
    public boolean repeatedSubstringPattern2(String s) {
        if ("".equals(s)) {
            return false;
        }

        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            // 更新 next 数组的值
            next[i] = j;
        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}
