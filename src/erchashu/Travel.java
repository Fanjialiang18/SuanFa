package erchashu;

import day01.TreeNode;

import java.util.*;

/**
 * @author clearlove3
 */
public class Travel {
    public List<Integer> preorderTravel(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
        return res;
    }

    public List<Integer> inorderTravel(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        //借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            //左边遍历完
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                cur=stack.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
    }
    public List<Integer> postorderTravel(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.left!=null){
                stack.push(pop.left);
            }
            if(pop.right!=null){
                stack.push(pop.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> levelOrderTravel(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            while (len>0){
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                len--;
            }
        }
        return res;
    }
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrderTravel1(TreeNode root){
        helper(root,0);
        return result;
    }

    /**
     * 递归层序
     */
    private void helper(TreeNode root,int deep){
        if(root==null){
            return;
        }
        deep++;
        if(result.size()<deep){
            List<Integer> item=new ArrayList<>();
            result.add(item);
        }
        result.get(deep-1).add(root.val);
        helper(root.left,deep);
        helper(root.right,deep);
    }
}
