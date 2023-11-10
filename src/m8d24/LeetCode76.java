package m8d24;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 需要多看
 * 思路：滑动窗口
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();// 需要凑齐的字符和数量
        Map<Character, Integer> window = new HashMap<>();// 用来记录窗口中的字符和数量
        //统计需要的字符及其数目
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 记录最小字串的起始位置和结束位置
        int start = 0, end = Integer.MAX_VALUE;
        // valid是用来记录窗口中满足need要求的字符和数量的字符的数目，
        // 比如need中要求字符a数量为2，如果window中的a字符的数量等于了2，valid就＋1，反之-1
        int l = 0, r = 0, valid = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果加入的字符是need中要求的字符，并且数量已经达到了need要求的数量，则valid+1
                if (need.get(c).intValue() == window.get(c).intValue()) {
                    valid++;
                }
            }
            // 当window中记录的字符和数量满足了need中要求的字符和数量，考虑缩窗口
            while (valid == need.size()) {
                // 先判断当前的最小覆盖字串是否比之前的最小覆盖字串短
                // 注意，这里上面已经对right实施了++操作，所以这里的长度不是right - left + 1
                if (r - l < end - start) {
                    start = l;
                    end = r;
                }
                char c1 = s.charAt(l);
                // 开始缩减窗口，left右移，如果要从window删除的字符正好是need中需要的并且，
                // 数目也等于need中需要的数目，则删减后，该该字符要求的数量
                // 显然不满足need要求的数量，所以valid要-1；
                l++;
                if (need.containsKey(c1)) {
                    if (need.get(c1).intValue() == window.get(c1).intValue()) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
