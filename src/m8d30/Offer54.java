package m8d30;

import day01.TreeNode;

/**
 * 二叉搜索树的第K大节点
 * 思路：
 *  中序遍历，倒数第k个结果就是
 *  或者修改中序遍历，使其左右反过来，那就是第k个
 * @author clearlove3
 */
public class Offer54 {
    private int res=0,cnt=0;
    public int kthLargest(TreeNode root, int k) {
        helper(root,k);
        return res;
    }
    private void helper(TreeNode root,int k){
        if(root==null){
            return;
        }
        helper(root.right,k);
        if(++cnt==k){
            res=root.val;
            return;
        }
        helper(root.left,k);
    }
}
