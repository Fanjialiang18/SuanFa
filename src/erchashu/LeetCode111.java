package erchashu;

import day01.TreeNode;

/**
 * 二叉树的最小深度
 *
 * @author clearlove3
 */
public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        } else if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        } else {
            return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
        }
    }
}
