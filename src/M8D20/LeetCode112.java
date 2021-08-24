package M8D20;

import day01.TreeNode;

/**
 * 路径总和
 * 思路：
 *  递归
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.val==targetSum&&root.left==null&&root.right==null)
            return true;
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
