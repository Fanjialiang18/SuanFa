package erchashu;

import day01.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 * 中序即有序数组，逐个更新差值即可
 * @author clearlove3
 */
public class LeetCode530 {
    /**
     * 记录上一个遍历的结点
     */
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) {
            return 0;
        }
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root==null) {
            return;
        }
        //左
        traversal(root.left);
        //中
        if(pre!=null){
            result = Math.min(result,root.val-pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }
}
