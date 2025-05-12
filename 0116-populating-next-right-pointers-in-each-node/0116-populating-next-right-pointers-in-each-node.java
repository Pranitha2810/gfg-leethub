/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null) return root;
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            ArrayList<Node> level = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                Node node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                level.add(node);
            }
            int levelSize = level.size();
            for(int i=0;i<levelSize-1;i++)
            {
                level.get(i).next=level.get(i+1);
            }
        }
        return root;
    }
}