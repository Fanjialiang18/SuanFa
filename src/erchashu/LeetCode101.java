package erchashu;

import day01.TreeNode;

/**
 * 对称二叉树
 * 递归
 * @author clearlove3
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return judge(root.left,root.right);
    }

    private boolean judge(TreeNode left,TreeNode right){
        if(left!=null&&right==null){
            return false;
        }else if(left==null&&right!=null){
            return false;
        }else if(left==null&&right==null){
            return true;
        }else if(left.val!=right.val){
            return false;
        }
        return judge(left.right,right.left)&&judge(left.left,right.right);
    }
}
