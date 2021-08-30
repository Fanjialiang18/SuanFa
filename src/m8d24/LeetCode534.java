package m8d24;

import day01.TreeNode;

/**
 * 二叉树的直径
 * 遍历每一个节点，以每一个节点为中心点计算最长路径（左子树边长+右子树边长），更新全局变量max。
 */
public class LeetCode534 {
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root.right==null&&root.left==null) {
            return 0;
        }
        int left,right;
        if(root.left==null) {
            left=0;
        } else {
            left=dfs(root.left)+1;
        }
        if(root.right==null) {
            right=0;
        } else {
            right=dfs(root.right)+1;
        }
        max=Math.max(max,left+right);
        return Math.max(left,right);
    }
}
