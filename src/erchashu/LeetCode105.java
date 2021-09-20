package erchashu;

import day01.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * @author clearlove3
 */
public class LeetCode105 {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        // val 为前序遍历第一个的值，也即是根节点的值
        int idx , val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        // idx 为根据根节点的值来找中序遍历的下标
        idx=map.get(val);
        // 根据 idx 来递归找左右子树
        root.left = helper(preorder, preLeft + 1, preLeft + (idx - inLeft),
                inorder, inLeft, idx - 1);
        root.right = helper(preorder, preLeft + (idx - inLeft) + 1, preRight,
                inorder, idx + 1, inRight);
        return root;
    }
}
