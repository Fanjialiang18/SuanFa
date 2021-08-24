package M8D20;

import day01.TreeNode;

/**
 * 平衡二叉树
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root)!=-1;
    }

    private int getDepth(TreeNode root){
        if(root==null)
            return 0;
        //分别求出左右子树的高度，然后如果差值小于等于1，则返回当前二叉树的高度，否则则返回-1，表示已经不是二叉树了。
        int left=getDepth(root.left);
        if(left==-1)
            return -1;
        int right=getDepth(root.right);
        if(right==-1)
            return -1;
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if(Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}
