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
        if(root==null) return 0;
        int sum=0;
        TreeNode leftChild=root.left;
        if(isLeaf(leftChild))
        {
            sum+=leftChild.val;
        }
        else
        {
            sum+=sumOfLeftLeaves(leftChild);
        }
        TreeNode rightChild=root.right;
        sum+=sumOfLeftLeaves(rightChild);
        return sum;
        
    }
    static boolean isLeaf(TreeNode node)
    {
        if(node==null) return false;
        if(node.left==null && node.right==null) return true;
        return false;
    }
}