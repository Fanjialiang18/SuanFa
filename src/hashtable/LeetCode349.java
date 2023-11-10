package hashtable;

import java.util.HashSet;

/**
 * 两个数组的交集
 * 思路：
 * 使用哈希表
 *
 * @author clearlove3
 */
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int start = 0;
        for (Integer integer : set2) {
            res[start++] = integer;
        }
        return res;
    }
}
