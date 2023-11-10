package m8d27;

/**
 * 二叉搜索树转换为双向链表
 * 思路：
 * 中序，递归
 * 和LeetCode426相同
 */
public class Offer36 {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        //pre为空说明是第一个节点，用head保存头节点
        if (pre == null) {
            head = root;
        }
        //否则就是上一个节点，将其和该节点链接
        else {
            pre.right = root;
        }
        //反向链接
        root.left = pre;
        // 保存当前节点，用于下层递归创建
        pre = root;
        inOrder(root.right);
    }
}
