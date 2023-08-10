package Search_Anything;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binary_Tree_Paths {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method binaryTreePaths：输出二叉树中所有从根到叶子的路径
     * @param TreeNode root：根节点
     * @return List<String> result：路径集合
     * @Address https://leetcode.cn/problems/binary-tree-paths/description/
     * @TitleName 257. 二叉树的所有路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        //路径结果集合 result 以及 某一可能结果 oneResult
        List<String> result = new ArrayList<>();
        StringBuilder oneResult = new StringBuilder();
        if (root == null)
            return result;
        dfs(root,result,oneResult);
        return result;
    }
    //深度优先
    void dfs(TreeNode root, List<String> result, StringBuilder oneResult){
        //访问节点为 null 则直接返回
        if (root == null)
            return;
        //临时变量存储当前路径
        StringBuilder temp = new StringBuilder(oneResult);
        //加入当前结点
        temp.append(root.val);
        //若当前结点结点为叶子结点，将当前路径加入结果 result 集合
        if (root.left == null && root.right == null){
            result.add(temp.toString());
            return;
        }
        //若不是，表明后续还有结点，添加 “->”
        temp.append("->");
        //继续遍历
        dfs(root.left,result,temp);
        dfs(root.right,result,temp);
    }

}
