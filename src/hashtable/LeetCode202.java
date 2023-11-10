package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * 思路：
 * 注意要用set保存每一步生成的数防止无限循环
 *
 * @author clearlove3
 */
public class LeetCode202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = cal(n);
        }
        return n == 1;
    }

    private int cal(int n) {
        int res = 0;
        while (n > 0) {
            int num = n % 10;
            res += num * num;
            n /= 10;
        }
        return res;
    }
}
