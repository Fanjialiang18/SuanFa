package m8d25;

import day01.TreeNode;

/**
 * 验证二叉搜索树
 * 思路1:
 *  递归
 * 思路2:
 *  中序遍历然后检查是否是升序
 */
public class LeetCode98 {
    TreeNode pre;// 用来记录前一个节点
    public boolean isValidBST(TreeNode root) {
        if(root==null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if(!left) {
            return false;
        }
        if(pre!=null&&root.val<=pre.val) {
            return false;
        }
        pre=root;
        return isValidBST(root.right);
    }

}
