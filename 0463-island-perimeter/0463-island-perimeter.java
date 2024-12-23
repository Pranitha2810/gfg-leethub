class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int perimeter=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int x=4;
                    if(j-1>=0 && grid[i][j-1]==1)
                    {
                        x--;
                    }
                    if(j+1<m &&grid[i][j+1]==1)
                    {
                        x--;
                    }
                    if(i-1>=0 && grid[i-1][j]==1)
                    {
                        x--;
                    }
                    if(i+1<n && grid[i+1][j]==1)
                    {
                        x--;
                    }
                    perimeter+=x;
                }
            }
        }
        return perimeter;
    }
}