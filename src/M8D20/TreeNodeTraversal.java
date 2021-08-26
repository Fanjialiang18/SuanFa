package M8D20;

import day01.TreeNode;

import java.util.*;


public class TreeNodeTraversal {
    /**
     * 前序
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                list.add(root.val);//步骤一，取根节点的值
                stack.push(root);//把根节点放入栈中
                root=root.left;//步骤二，遍历左子树
            }
            else{
                TreeNode tem=stack.pop();
                root=tem.right;//步骤三，遍历右子树
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
                stack.push(root);//把根节点放入栈中
                root=root.left;//步骤一，遍历左子树
            }
            else{
                TreeNode tem=stack.pop();
                list.add(tem.val);//步骤二，取根结点的值
                root=tem.right;//步骤三，遍历右子树
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
                stack.push(root);//把根节点放入栈中
                list.add(0, root.val);//步骤一，在index=0处插入根结点的值
                root = root.right;//步骤二，遍历右子树
            } else {
                TreeNode tem = stack.pop();
                root = tem.left;//步骤三，遍历左子树
            }
        }
        return list;
    }

    /**
     * 层序
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new LinkedList<>();// LinkedList优化每次从头进行添加
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return lists;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for(TreeNode t:queue){
                list.add(t.val);
            }
            while (!queue.isEmpty()){//添加下一层的节点
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.add(poll.left);
                if(poll.right!=null)
                    queue.add(poll.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
