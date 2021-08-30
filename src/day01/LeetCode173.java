package day01;

import java.util.Stack;

public class LeetCode173 {
    TreeNode list=null;
    //public BSTIterator(TreeNode root) {
    public LeetCode173(TreeNode root) {
            bulid(root);
    }
    public void bulid(TreeNode root){
        if(root.right!=null) {
            bulid(root.right);
        }
        root.right=list;
        list=root;
        if(root.left!=null) {
            bulid(root.left);
        }
    }
    public int next() {
        int val= list.val;
        list=list.right;
        return val;
    }

    public boolean hasNext() {
        return list!=null;
    }
}
