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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode x=st.pop();
            ans.add(x.val);
            if(x.right != null)
                st.push(x.right);
            if(x.left != null)
                st.push(x.left);
        }
        return ans;
    }
}