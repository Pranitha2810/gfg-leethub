/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentMap=parent(root);
        Queue<TreeNode> q= new LinkedList<>();
        HashSet<TreeNode> st=new HashSet<>();
        q.add(target);
        st.add(target);
        int curLevel=0;
        while(!q.isEmpty())
        {
            if(curLevel==k)
                break;
            curLevel++;
            int curSize=q.size();
            for(int i=0;i<curSize;i++)
            {
                TreeNode node = q.poll();
                if(node.left != null && st.contains(node.left)==false)
                {
                    q.add(node.left);
                    st.add(node.left);
                }
                if(node.right!=null && st.contains(node.right)==false)
                {
                    q.add(node.right);
                    st.add(node.right);
                }
                if(parentMap.get(node)!=null && st.contains(parentMap.get(node))==false)
                {
                    q.add(parentMap.get(node));
                    st.add(parentMap.get(node));
                }
            }
           
        }
        ArrayList<Integer> res=new ArrayList<>();
            while(!q.isEmpty())
            {
                res.add(q.peek().val);
                q.poll();
            }
        return res;
        
    }
    static HashMap<TreeNode,TreeNode> parent(TreeNode root)
    {
        HashMap<TreeNode,TreeNode> mp= new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.left != null)
            {
                mp.put(node.left,node);
                q.add(node.left);
            }
            if(node.right != null)
            {
                mp.put(node.right,node);
                q.add(node.right);
            }
        }
        return mp;
    }
}