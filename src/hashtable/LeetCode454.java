package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 * 思路：
 * 两数之和和两数之和，o(n^2)
 *
 * @author clearlove3
 */
public class LeetCode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int tmp = i + j;
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                } else {
                    map.put(tmp, 1);
                }
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                int tmp = i + j;
                if (map.containsKey(-tmp)) {
                    res += map.get(-tmp);
                }
            }
        }
        return res;
    }
}
