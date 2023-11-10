package day01;

import java.util.*;

public class LeetCode103 {
    /**
     * 二叉树的锯齿遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;//用于记录是否是偶数层
        if (root == null) {
            return lists;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            for (TreeNode t : queue) {
                list.add(t.val);
                i++;
            }
            while (i != 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                i--;
            }
            if (flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }
}
