package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 思路：
 * 用哈希表保存该数对应的另一个数和其下标即可
 * 遍历
 *
 * @author clearlove3
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                result[1] = i;
                result[0] = m.get(nums[i]);
                return result;
            }
            m.put(target - nums[i], i);
        }
        return null;
    }
}
