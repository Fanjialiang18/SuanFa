package erchashu;

import day01.TreeNode;

/**
 * 平衡二叉树
 * @author clearlove3
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return judge(root)!=-1;
    }
    private int judge(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=judge(root.left);
        if(left==-1){
            return -1;
        }
        int right=judge(root.right);
        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        return 1+Math.max(left,right);
    }
}
