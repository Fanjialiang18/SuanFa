package erchashu;

import day01.TreeNode;

/**
 * 路径总和
 * @author clearlove3
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) {
            return false;
        }
        if(root.val==targetSum&&root.left==null&&root.right==null) {
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
