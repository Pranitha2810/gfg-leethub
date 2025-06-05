class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n=s1.length();
        int m=baseStr.length();
        HashMap<Character,List<Character>> adj = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char u=s1.charAt(i);
            char v=s2.charAt(i);
            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(v).add(u);
            adj.get(u).add(v);    
        }
        String result="";
        for(int i=0;i<m;i++)
        {
            char ch=baseStr.charAt(i);
            int[] visited = new int[26];
            char minchar = DFS(adj,ch,visited);
            result=result+minchar;
        }
        return result;
    }
    private char DFS(HashMap<Character,List<Character>> adj,char curr_ch,int[] visited)
    {
        if (!adj.containsKey(curr_ch)) return curr_ch;
        char minchar = curr_ch;
        visited[curr_ch-'a']=1;
        for(char v : adj.get(curr_ch))
        {
            if(visited[v-'a']==0)
                minchar = (char)Math.min(minchar,DFS(adj,v,visited));
        }
        return minchar;
    }
}