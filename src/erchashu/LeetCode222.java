package erchashu;

import day01.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树节点个数
 * 递归，迭代
 * @author clearlove3
 */
public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    public int countNodes2(TreeNode root){
        int result=0;
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode poll = queue.poll();
                result++;
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return result;
    }
}
