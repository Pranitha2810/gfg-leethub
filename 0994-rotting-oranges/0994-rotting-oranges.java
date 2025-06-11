public class Triplet
{
    int r;
    int c;
    int t;
    Triplet(int r,int c,int t)
    {
        this.r=r;
        this.c=c;
        this.t=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Triplet> q = new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited= new int[n][m];
        int cntFresh=0;
        int cnt=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Triplet(i,j,0));
                    visited[i][j]=2;
                }
                else if(grid[i][j]==1)
                {
                    cntFresh++;
                }
            }
        }
        int[] di={-1,0,+1,0};
        int[] dj={0,+1,0,-1};
        while(!q.isEmpty())
        {
            Triplet x=q.remove();
            int r=x.r;
            int c=x.c;
            int t=x.t;
            ans=Math.max(ans,t);
            for(int i=0;i<4;i++)
            {
                int new_r=r+di[i];
                int new_c=c+dj[i];
                if(new_r>=0 && new_r<n && new_c>=0 && new_c<m && visited[new_r][new_c]!=2 && grid[new_r][new_c]==1)
                {
                    q.add(new Triplet(new_r,new_c,t+1));
                    visited[new_r][new_c]=2;
                    cnt++;
                }
            }
        }
        if(cntFresh > cnt) return -1;
        return ans;
    }
}