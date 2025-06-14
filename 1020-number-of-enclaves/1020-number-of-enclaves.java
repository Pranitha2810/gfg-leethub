public class Pair
{
    int i;
    int j;
    Pair(int i,int j)
    {
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        //using bfs
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //first,last row and col
                if(i==0 || i==n-1 || j==0 || j==m-1)
                {
                    if(grid[i][j]==1)
                    {
                        q.add(new Pair(i,j));
                        visited[i][j]=1;
                    }
                }
            }
        }
        int[] di = {-1,0,+1,0};
        int[] dj = {0,+1,0,-1};
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            for(int k=0;k<4;k++)
            {
                int newi=p.i+di[k];
                int newj=p.j+dj[k];
                if(newi>=0 && newi<n && newj>=0 && newj<m && grid[newi][newj]==1 && visited[newi][newj]==0)
                {
                    q.add(new Pair(newi,newj));
                    visited[newi][newj]=1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && visited[i][j]==0)
                    ans++;
            }
        }
        return ans;
    }
}