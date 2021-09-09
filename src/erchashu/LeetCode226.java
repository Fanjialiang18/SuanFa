package erchashu;

import day01.TreeNode;

import java.util.Stack;

/**
 * 翻转二叉树
 * @author clearlove3
 */
public class LeetCode226 {
    /**
     * 递归
     */
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

    /**
     * 迭代
     */
    public TreeNode invertTree2(TreeNode root) {
        if(root==null) {
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            TreeNode temp=pop.left;
            pop.left= pop.right;
            pop.right=temp;
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
        return root;
    }
}
