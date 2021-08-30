package m8d20;

import day01.TreeNode;

import java.util.*;

/**
 * 二叉树的后序遍历
 */
public class LeetCode145 {
    /**
     * 递归
     */
    List<Integer> res=new ArrayList<>();
    public List<Integer> postorderTraversal2(TreeNode root) {
        if(root==null) {
            return res;
        }
        if(root.left!=null) {
            postorderTraversal2(root.left);
        }
        if(root.right!=null) {
            postorderTraversal2(root.right);
        }
        res.add(root.val);
        return res;
    }

    /**
     * 利用pre记录上一个访问过的结点，
     * 与当前结点比较，如果是当前结点的子节点，
     * 说明其左右结点均已访问，将当前结点出栈，
     * 更新pre记录的对象
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if((curr.left == null && curr.right == null) ||
                    (pre != null && (pre == curr.left || pre == curr.right))){
                //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
                res.add(curr.val);
                pre = curr;
                stack.pop();
            }else{
                if(curr.right != null) {
                    stack.push(curr.right); //先将右结点压栈
                }
                if(curr.left != null) {
                    stack.push(curr.left);   //再将左结点入栈
                }
            }
        }
        return res;
    }

    /**
     * 前序为中左右
     * 将前序的调整为中右左后翻转即可为左右中
     */
    public List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null) {
            return result;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(pop.left!=null) {
                stack.push(pop.left);
            }
            if(pop.right!=null) {
                stack.push(pop.right);
            }
            result.add(0,pop.val);
        }
        return result;
    }
}
