package m8d6;

/**
 * 接雨水
 */
public class LeetCode42 {
    /**
     * 双指针法
     * 如果一端有更高的条形块（例如右端），
     * 积水的高度依赖于当前方向的高度（从左到右）。
     * 当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
     * 我们必须在遍历时维护 left_max 和 right_max ，
     * 但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int max_left = 0, max_right = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > max_left) {
                    max_left = height[left];
                } else {
                    res += max_left - height[left];
                }
                left++;
            } else {
                if (height[right] > max_right) {
                    max_right = height[right];
                } else {
                    res += max_right - height[right];
                }
                right--;
            }
        }
        return res;
    }

    /**
     * 暴力解法
     * 两次循环，找每个点能蓄水的高度
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int res = 0;
        //遍历两遍找寻该点能蓄水的高度
        //为其两边的最大高度中的最小值减去该点的高度
        for (int i = 1; i < height.length - 1; i++) {
            int left_max = 0, right_max = 0;
            for (int j = i; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            res += Math.min(left_max, right_max) - height[i];
        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null) {
            return 0;
        }
        int res = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        max_left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(height[i], max_left[i - 1]);
        }
        max_right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(height[i], max_right[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(max_left[i], max_right[i]) - height[i];
        }
        return res;
    }
}
