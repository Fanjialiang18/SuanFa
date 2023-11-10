package erchashu;

import day01.TreeNode;

/**
 * 左叶子之和
 * 递归
 * 使用flag来标记是否是左叶子
 *
 * @author clearlove3
 */
public class LeetCode404 {
    int sum = 0;
    boolean flag = false;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (flag) {
                sum += root.val;
            } else {
                return 0;
            }
        }
        flag = true;
        sumOfLeftLeaves(root.left);
        flag = false;
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
