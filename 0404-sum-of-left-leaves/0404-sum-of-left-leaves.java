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
    public int sumOfLeftLeaves(TreeNode root) {
        //bfs
        if(root == null) return 0;
        int sum=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.left != null)
            {
                //check if left node is leaf or not
                if(node.left.left == null && node.left.right==null) 
                    sum+=node.left.val;
                else
                    q.add(node.left);
            }
            if(node.right != null)
            {
                q.add(node.right);
            }
        }
        return sum;
    }
}