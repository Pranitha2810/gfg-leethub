class Triplet
{
    int r;
    int c;
    int s;
    Triplet(int r,int c,int s)
    {
        this.r=r;
        this.c=c;
        this.s=s;
    }
}
class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited = new int[n][m];
        int[][] ans= new int[n][m];
        Queue<Triplet> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    visited[i][j]=1;
                    q.add(new Triplet(i,j,0));
                }
            }
        }
        int[] di={-1,0,+1,0};
        int[] dj={0,+1,0,-1};
        while(!q.isEmpty())
        {
            Triplet x=q.remove();
            int i=x.r;
            int j=x.c;
            int s=x.s;
            ans[i][j]=s;
            for(int k=0;k<4;k++)
            {
                int newi=i+di[k];
                int newj=j+dj[k];
                if(newi>=0 && newi<n && newj>=0 && newj<m && visited[newi][newj]==0)
                {
                    q.add(new Triplet(newi,newj,s+1));
                    visited[newi][newj]=1;
                }
            }
        }
        return ans;
    }
}