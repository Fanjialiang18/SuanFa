package m8d20;

import day01.TreeNode;

import java.util.Arrays;

/**
 * 最大路径和
 * 最大路径和：根据当前节点的角色，路径和可分为两种情况：
 * 一：以当前节点为根节点
 * 1.只有当前节点
 * 2.当前节点+左子树
 * 3.当前节点+右子书
 * 4.当前节点+左右子树
 * 这四种情况的最大值即为以当前节点为根的最大路径和
 * 此最大值要和已经保存的最大值比较，得到整个树的最大路径值
 * <p>
 * 二：当前节点作为父节点的一个子节点
 * 和父节点连接的话则需取【单端的最大值】
 * 1.只有当前节点
 * 2.当前节点+左子树
 * 3.当前节点+右子书
 * 这三种情况的最大值
 */
public class LeetCode124 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        int v1 = root.val;
        int v2 = root.val + left;
        int v3 = root.val + right;
        int v4 = root.val + left + right;
        int max = Arrays.stream(new int[]{v1, v2, v3, v4}).max().getAsInt();
        res = Math.max(max, res);
        return Arrays.stream(new int[]{v1, v2, v3}).max().getAsInt();

    }
}
