package m8d23;

import day01.TreeNode;

/**
 * 求根节点到叶节点数字之和
 * 思路：
 *  递归求和
 */
public class LeetCode129 {
    private int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        helper(0,root);
        return sum;
    }

    private void helper(int val,TreeNode node){
        if(node==null) {
            return ;
        }
        int k=val*10+node.val;
        if(node.left==null&&node.right==null) {
            sum+=k;
        }
        helper(k,node.left);
        helper(k,node.right);
    }
}
