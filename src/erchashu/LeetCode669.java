package erchashu;

import day01.TreeNode;

/**
 * 修剪二叉搜索树
 * 递归
 *
 * @author clearlove3
 */
public class LeetCode669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            // 寻找符合区间[low, high]的节点
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            // 寻找符合区间[low, high]的节点
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        // root->left接入符合条件的左孩子
        root.left = trimBST(root.left, low, high);
        // root->right接入符合条件的右孩子
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
