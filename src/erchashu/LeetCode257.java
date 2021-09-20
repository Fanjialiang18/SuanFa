package erchashu;

import day01.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 递归，回溯
 * @author clearlove3
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer> paths=new ArrayList<>();
        findPath(root,paths,res);
        return res;
    }
    private void findPath(TreeNode root,List<Integer> paths,List<String> res){
        paths.add(root.val);
        if(root.left==null&&root.right==null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            findPath(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) {
            findPath(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}
