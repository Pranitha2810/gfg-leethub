class Solution {
    int n,m,nonObstacles,result;
    public int uniquePathsIII(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        result=0;
        int start_x=0;
        int start_y=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                    nonObstacles++;
                if(grid[i][j]==1)
                {
                    start_x=i;
                    start_y=j;
                }
            }
        }
        nonObstacles++;
        int count=0;
        backT(grid,count,start_x,start_y);
        return result;
    }
    private void backT(int[][] grid,int count,int i,int j)
    {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==-1) return;
        if(grid[i][j]==2)
        {
            if(count==nonObstacles)
            {
                result++;
            }
            return;
        }
        grid[i][j]=-1;
        for(int x=0;x<4;x++)
        {
            int new_i=i+di[x];
            int new_j=j+dj[x];
            backT(grid,count+1,new_i,new_j);
        }
        grid[i][j]=0;
    }
    static int[] di={-1,0,+1,0};
    static int[] dj={0,+1,0,-1};
}