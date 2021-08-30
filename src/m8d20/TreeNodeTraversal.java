package m8d20;

import day01.TreeNode;

import java.util.*;


/**
 * @author 25322
 */
public class TreeNodeTraversal {
    /**
     * 前序
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                //步骤一，取根节点的值
                list.add(root.val);
                //把根节点放入栈中
                stack.push(root);
                //步骤二，遍历左子树
                root=root.left;
            }
            else{
                TreeNode tem=stack.pop();
                //步骤三，遍历右子树
                root=tem.right;
            }
        }
        return list;
    }

    /**
     * 中序
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                //把根节点放入栈中
                stack.push(root);
                //步骤一，遍历左子树
                root=root.left;
            }
            else{
                TreeNode tem=stack.pop();
                //步骤二，取根结点的值
                list.add(tem.val);
                //步骤三，遍历右子树
                root=tem.right;
            }
        }
        return list;
    }

    /**
     * 后序
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || (!stack.empty())) {
            if (root != null) {
                //把根节点放入栈中
                stack.push(root);
                //步骤一，在index=0处插入根结点的值
                list.add(0, root.val);
                //步骤二，遍历右子树
                root = root.right;
            } else {
                TreeNode tem = stack.pop();
                //步骤三，遍历左子树
                root = tem.left;
            }
        }
        return list;
    }

    /**
     * 层序
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // LinkedList优化每次从头进行添加
        List<List<Integer>> lists=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) {
            return lists;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for(TreeNode t:queue){
                list.add(t.val);
            }
            //添加下一层的节点
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if(poll.left!=null) {
                    queue.add(poll.left);
                }
                if(poll.right!=null) {
                    queue.add(poll.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
