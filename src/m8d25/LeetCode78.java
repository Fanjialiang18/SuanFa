package m8d25;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 思路:
 * 遍历,将每个子集加上该数形成新的子集
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}
