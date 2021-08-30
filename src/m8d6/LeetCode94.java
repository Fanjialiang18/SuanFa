package m8d6;

import day01.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 思路1：递归
 * 思路2：迭代
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        //左链入栈
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            pop = pop.right;
            //右边节点访问过也要将其左边入栈
            while (pop != null) {
                stack.push(pop);
                pop = pop.left;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Helper(root.left, list);
        list.add(root.val);
        Helper(root.right, list);
        return list;
    }

    public void Helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Helper(root.left, list);
        list.add(root.val);
        Helper(root.right, list);
    }
}
