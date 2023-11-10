package erchashu;

import day01.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * @author clearlove3
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遍历到叶子节点时候返回null
        if (root == null) {
            return null;
        }
        //找到p或者q时候返回q
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        }
        return right;
    }
}
