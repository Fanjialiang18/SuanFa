package erchashu;

import day01.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和2
 *
 * @author clearlove3
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, res, path);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        //找到路径
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1);//回溯
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);//回溯
        }
    }
}
