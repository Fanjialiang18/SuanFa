package m8d7;

import day01.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * 使用层序遍历，并只保留每层最后一个节点的值
 */
public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int val = 0;
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            while (num > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);//add加元素时候满了会异常，offer会返回false
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                num--;
                val = poll.val;
            }
            list.add(val);
        }
        return list;
    }
}
