package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 * 哈希表
 * 或者数组
 * 数组的复杂度更低，因为哈希表的各种判断需要费时
 *
 * @author clearlove3
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                Integer num = map.get(c);
                num--;
                if (num != 0) {
                    map.put(c, num);
                } else {
                    map.remove(c);
                }
            }
            if (map.isEmpty()) {
                return true;
            }
        }
        return map.isEmpty();
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] res = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            res[c - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            res[c - 'a']--;
        }
        for (int i : res) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
