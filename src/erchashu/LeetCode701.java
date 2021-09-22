package erchashu;

import day01.TreeNode;

/**
 * 二叉搜索树中的插入操作
 * @author clearlove3
 */
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }else {
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }
}
