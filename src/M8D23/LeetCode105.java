package M8D23;

import day01.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 说到一层一层切割，就应该想到了递归。
 *
 * 来看一下一共分几步：
 *
 * 第一步：如果数组大小为零的话，说明是空节点了。
 * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
 * 第三步：找到前序数组第一个元素在中序数组的位置，作为切割点
 * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
 * 第五步：切割前序数组，切成前序左数组和前序右数组
 * 第六步：递归处理左区间和右区间
 */
public class LeetCode105 {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     */
    public TreeNode helper(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;

        // val 为前序遍历第一个的值，也即是根节点的值
        // idx 为根据根节点的值来找中序遍历的下标
        int idx , val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        //使用map来提高效率
        idx=map.get(val);
//        for (int i = inLeft; i <= inRight; i++) {
//            if (inorder[i] == val) {
//                idx = i;
//                break;
//            }
//        }

        // 根据 idx 来递归找左右子树
        // 依然左闭右闭，注意这里使用了左中序数组大小作为切割点
        root.left = helper(preorder, preLeft + 1, preLeft + (idx - inLeft),
                inorder, inLeft, idx - 1);
        root.right = helper(preorder, preLeft + (idx - inLeft) + 1, preRight,
                inorder, idx + 1, inRight);
        return root;
    }
}

