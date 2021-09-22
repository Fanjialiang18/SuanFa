package erchashu;

import day01.TreeNode;

/**
 * 验证二叉搜索树
 * 中序
 * @author clearlove3
 */
public class LeetCode98 {
    /**
     * 用来记录前一个节点
     */
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if(root==null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if(!left) {
            return false;
        }
        if(pre!=null&&root.val<=pre.val) {
            return false;
        }
        pre=root;
        return isValidBST(root.right);
    }
}
