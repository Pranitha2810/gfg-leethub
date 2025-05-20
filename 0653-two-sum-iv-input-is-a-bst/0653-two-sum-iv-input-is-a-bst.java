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
    public boolean findTarget(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        inOrderTraversal(list,root);
        int n=list.size();
        int i=0,j=n-1;
        while(i<j)
        {
            if((list.get(i).val+list.get(j).val) == k)
                return true;
            if((list.get(i).val+list.get(j).val)<k)
                i++;
            else
                j--;
        }
        return false;
    }
    private void inOrderTraversal(List<TreeNode> list, TreeNode root)
    {
        if(root==null)
            return ;
        inOrderTraversal(list,root.left);
        list.add(root);
        inOrderTraversal(list,root.right);
    }
}