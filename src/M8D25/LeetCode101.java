package M8D25;

import day01.TreeNode;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 思路:
 *  递归
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return judge(root.left,root.right);
    }

    private boolean judge(TreeNode left,TreeNode right){
        // 首先排除空节点的情况
        if(left==null&&right!=null)
            return false;
        else if(left!=null&&right==null)
            return false;
        else if (left==null&&right==null)
            return true;
        //然后排除数值不同的情况
        else if(left.val!=right.val)
            return false;
        //此时数值相同,做递归
        //对称即左子树的右孩子和右子树的左孩子相同
        boolean outside = judge(left.left, right.right);
        boolean inside = judge(left.right, right.left);
        return outside&&inside;
    }
}
