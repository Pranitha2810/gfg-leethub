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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preOrderTraversal(root,list);
        int n=list.size();
        TreeNode dup = root;
        for(int i=1;i<n;i++)
        {
            dup.left=null;
            dup.right=list.get(i);
            dup=dup.right;
        }
    }
    static void preOrderTraversal(TreeNode root,ArrayList<TreeNode> list)
    {
        if(root == null)
            return ;
        list.add(root);
        preOrderTraversal(root.left,list);
        preOrderTraversal(root.right,list);
    }

}