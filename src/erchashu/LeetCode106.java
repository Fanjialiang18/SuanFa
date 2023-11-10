package erchashu;

import day01.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author clearlove3
 */
public class LeetCode106 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //左闭右开
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode helper(int[] inorder, int inorderLeft, int inorderRight,
                            int[] postorder, int postorderLeft, int postorderRight) {
        // 递归终止条件
        if (inorderRight - inorderLeft < 1)
            return null;
        // 只有一个元素了
        if (inorderRight - inorderLeft == 1) {
            return new TreeNode(inorder[inorderLeft]);
        }
        // 后序数组postorder里最后一个即为根结点
        int val = postorder[postorderRight - 1];
        TreeNode root = new TreeNode(val);
        // 根据根结点的值找到该值在中序数组inorder里的位置
        int index = map.get(val);
        // 根据rootIndex划分左右子树
        root.left = helper(inorder, inorderLeft, index,
                postorder, postorderLeft, postorderLeft + (index - inorderLeft));
        root.right = helper(inorder, index + 1,
                inorderRight, postorder, postorderLeft + (index - inorderLeft), postorderRight - 1);
        return root;
    }
}
