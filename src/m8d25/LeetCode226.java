package m8d25;

import day01.TreeNode;

/**
 * 翻转二叉树
 * 思路：
 *  递归即可
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
