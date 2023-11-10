package erchashu;

import day01.TreeNode;

/**
 * 二叉树的最大深度
 * 递归或者层序遍历
 *
 * @author clearlove3
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    private int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = 0, right = 0;
        left = getDepth(root.left, depth + 1);
        right = getDepth(root.right, depth + 1);
        return Math.max(left, right);
    }
}
