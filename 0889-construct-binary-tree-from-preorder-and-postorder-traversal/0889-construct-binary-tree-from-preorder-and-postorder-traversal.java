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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<postorder.length;i++)
        {
            mp.put(postorder[i],i);
        }
        TreeNode root = ConstructTree(preorder,0,preorder.length-1,postorder,0,postorder.length-1,mp);
        return root;
    }
    static TreeNode ConstructTree(int[] preorder,int prestart,int preend,int[] postorder,int poststart,int postend,HashMap<Integer,Integer>mp)
    {
        if(prestart>preend || poststart>postend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preend) return root;
        int leftroot_index_post = mp.get(preorder[prestart+1]);
        int number_of_elements_on_left=leftroot_index_post - poststart+1;
        root.left = ConstructTree(preorder,prestart+1,prestart+number_of_elements_on_left,postorder,poststart,leftroot_index_post,mp);
        root.right=ConstructTree(preorder,prestart+number_of_elements_on_left+1,preend,postorder,leftroot_index_post+1,postend-1,mp);
        return root;
    }
}