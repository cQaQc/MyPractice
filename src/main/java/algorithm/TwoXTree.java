package algorithm;
/**
 *作者: 柯神_
 *时间: 22:38
 *日期: 2020/10/29
 *User: 蜘蛛啊全是腿儿
 *
 *
 * 将二叉搜索树 转换为 单向链表
 *   对二叉搜索树采用中序遍历就可以得到一个升序序列
 *
**/
public class TwoXTree {

    TreeNode head = new TreeNode(-1);

    TreeNode pre = null;

    public TreeNode convert(TreeNode root){
        help(root);
        return head.right;
    }

    public void help(TreeNode root){
        if (root == null){return;}
        help(root.left);
        if (pre == null){
            pre = root;
            head.right=root;
        }
        else {
            pre.right=root;
            pre=root;
        }
        root.left=null;
        help(root.right);

    }


    public static void main(String[] args) {

    }
}

class TreeNode{
    int v;
    TreeNode left;
    TreeNode right;
    TreeNode(int n){
        v = n;
    }
}