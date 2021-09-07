package hashtable;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 有效的字母异位词
 * 思路1：
 *  使用哈希表
 * 思路2：
 *  使用数组即可
 * @author clearlove3
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);
            int num = hashMap.getOrDefault(c,0);
            if(num==0){
                return false;
            }
            num--;
            if(num!=0){
                hashMap.put(c,num);
            }else {
                hashMap.remove(c);
            }

        }
        return hashMap.isEmpty();
    }
    public boolean isAnagram2(String s, String t) {
        int[] used=new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            used[c-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);
            used[c-'a']--;
        }
        for (int j : used) {
            if (j != 0) {
                return false;
            }
        }
        return true;

    }
}
