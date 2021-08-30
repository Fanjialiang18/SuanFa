package m8d26;

import day01.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的完全性检验
 * 思路：
 *  层序遍历，设置一个停止标志，遇到空节点，停止标志为真，如果停止标志为真，再遍历遇到非空节点，则非完全二叉树。
 * 广度遍历就是层序遍历。。。
 */
public class LeetCode958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        boolean flag = false;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp == null) {
                flag = true;
                continue;
            }
            if (flag) {
                return false;
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return true;
    }
}
