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
class Solution {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrderTraversal(root,list);
        int res=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++)
        {
            res=Math.min(res,Math.abs(list.get(i).val-list.get(i-1).val));
        }
        return res;
    }
    static void inOrderTraversal(TreeNode node,ArrayList<TreeNode> list)
    {
        if(node==null) return;
        inOrderTraversal(node.left,list);
        list.add(node);
        inOrderTraversal(node.right,list);
    }
}