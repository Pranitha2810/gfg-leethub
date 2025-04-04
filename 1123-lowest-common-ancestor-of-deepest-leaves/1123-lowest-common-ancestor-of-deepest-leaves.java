/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode lca;
    int depth;
    Pair(TreeNode lca , int depth)
    {
        this.lca=lca;
        this.depth=depth;
    }
}
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair result = dfs(root);
        return result.lca;
    }
    private static Pair dfs(TreeNode cur)
    {
        if(cur == null) return new Pair(null,0);
        Pair left_ans = dfs(cur.left);
        Pair right_ans = dfs(cur.right);
        if(left_ans.depth == right_ans.depth)
            return new Pair(cur,left_ans.depth+1);
        else if(left_ans.depth>right_ans.depth)
            return new Pair(left_ans.lca,left_ans.depth+1);
        return new Pair(right_ans.lca,right_ans.depth+1);
    }
}