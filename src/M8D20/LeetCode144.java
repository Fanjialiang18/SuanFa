package M8D20;

import day01.TreeNode;

import java.util.*;

/**
 * 二叉树前序遍历
 * 思路1：
 *  递归
 * 思路2：
 *  迭代
 */
public class LeetCode144 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root==null)
            return res;
        res.add(root.val);
        if (root.left!=null)
            preorderTraversal2(root.left);
        if(root.right!=null)
            preorderTraversal2(root.right);
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if(pop.right!=null)
                    stack.add(pop.right);
                if(pop.left!=null)
                    stack.add(pop.left);
        }
        return result;
    }
}
