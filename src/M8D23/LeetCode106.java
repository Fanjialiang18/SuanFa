package M8D23;

import day01.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据后序和中序遍历构造二叉树
 * 第一步：如果数组大小为零的话，说明是空节点了。
 * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
 * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
 * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
 * 第五步：切割后序数组，切成后序左数组和后序右数组
 * 第六步：递归处理左区间和右区间
 */
public class LeetCode106 {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        //左闭右开
        return helper(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode helper(int[] inorder,int inorderLeft,int inorderRight,
                            int[] postorder,int postorderLeft,int postorderRight){
        // 递归终止条件
        if(inorderRight-inorderLeft<1)
            return null;
        //只有一个元素
        if (inorderRight - inorderLeft == 1) {
            return new TreeNode(inorder[inorderLeft]);
        }
        int val=postorder[postorderRight-1];
        TreeNode root = new TreeNode(val);
        int index=map.get(val);
        root.left=helper(inorder,inorderLeft,index,
                postorder,postorderLeft,postorderLeft+(index-inorderLeft));
        root.right=helper(inorder,index+1,inorderRight,
                postorder,postorderLeft+(index-inorderLeft),postorderRight-1);
        return root;
    }

}
