package erchashu;

import day01.TreeNode;

/**
 * 删除二叉搜索树中的节点
 *
 * @author clearlove3
 */
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //没找到删除的节点，遍历到空节点直接返回了
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            //其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
            if (root.left == null) {
                return root.right;
            }
            //其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
            if (root.right == null) {
                return root.left;
            }
            //左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            root.val = tmp.val;
            root.right = deleteNode(root.right, tmp.val);
        }
        return root;
    }
}
