package algorithm.tree;

/**
 *
 * @author 柯神_
 * @date 2020-11-27 21:21:25
 * @Description
 *                  求二叉树的最大深度
 * @param
 * @return
*/
public class TreeDepth {

    /**
     *
     * @author 柯神_
     * @date 2020-11-27 21:29:15
     * @Description    递归求解： 当前节点为空，高度为0，
    */
    public int maxDepth(TreeNode treeNode){
        return treeNode == null ?
                0 : Math.max(maxDepth(treeNode.left),maxDepth(treeNode.right)) + 1;
    }
}
