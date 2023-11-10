package dp.Pack0_1;

/**
 * 最后一块石头
 * 01背包
 *
 * @author clearlove3
 */
public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] res = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                res[j] = Math.max(res[j], res[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * res[target];
    }
}
