package day01;

import java.util.*;

public class LeetCode102 {
    /**
     * 二叉树的层序遍历
     * 使用队列和LinkedList
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new LinkedList<>();// LinkedList优化每次从头进行添加
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return lists;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int i=0;//用i记录每层的节点数
            for(TreeNode t:queue){
                list.add(t.val);
                i++;
            }
            while (!queue.isEmpty()){//添加下一层的节点
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.add(poll.left);
                if(poll.right!=null)
                    queue.add(poll.right);
                i--;
            }
            lists.add(list);
        }
        return lists;
    }
}
