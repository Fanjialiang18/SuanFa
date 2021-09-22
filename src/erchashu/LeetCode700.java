package erchashu;

import day01.TreeNode;

/**
 * 二叉搜索树中的搜索
 * 递归
 * 使用BST的特性
 * @author clearlove3
 */
public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }else if(root.val==val){
            return root;
        }else{
            if(root.val>val){
                return searchBST(root.left,val);
            }else {
                return searchBST(root.right,val);
            }
        }
    }
}
