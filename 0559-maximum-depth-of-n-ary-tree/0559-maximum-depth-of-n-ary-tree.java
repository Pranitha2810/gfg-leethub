/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        //bfs
        if(root == null) return 0;
        int depth=0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                Node node = q.poll();
                if(node.children != null)
                {
                    for (Node child : node.children) 
                    {
                        q.add(child);
                    }
                }
            }
            depth++;
        }
        return depth;
        
    }
}