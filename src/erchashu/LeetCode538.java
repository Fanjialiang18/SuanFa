package erchashu;

import day01.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 * 累加的顺序是右中左
 * 需要反中序遍历这个二叉树，然后顺序累加就可以了
 *
 * @author clearlove3
 */
public class LeetCode538 {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    /**
     * 按右中左顺序遍历，累加即可
     */
    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }
}
