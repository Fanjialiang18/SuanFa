package erchashu;

import day01.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 * 层序遍历，每层最左边的值
 *
 * @author clearlove3
 */
public class LeetCode513 {
    public int findBottomLeftValue(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    max = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return max;
    }
}
