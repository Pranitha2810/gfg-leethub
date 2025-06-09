class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans= new ArrayList<>();
        int n=maze.length;
        int m=maze[0].length;
        int[][] visited = new int[n][m];
        if(maze[0][0]==1)
            solve(0,0,n,m,ans,"",visited,maze);
        return ans;
    }
    private void solve(int i,int j,int n,int m,ArrayList<String>ans,String move,int[][]visited,int[][]maze)
    {
        if(i==n-1 && j==m-1)
        {
            ans.add(move);
            return;
        }
        //down
        if((i+1)<n && visited[i+1][j]==0 && maze[i+1][j]==1)
        {
            visited[i][j]=1;
            solve(i+1,j,n,m,ans,move+"D",visited,maze);
            visited[i][j]=0;
        }
        //left
        if((j-1)>=0 && visited[i][j-1]==0 && maze[i][j-1]==1)
        {
            visited[i][j]=1;
            solve(i,j-1,n,m,ans,move+"L",visited,maze);
            visited[i][j]=0;
        }
        //right
         if((j+1)<m && visited[i][j+1]==0 && maze[i][j+1]==1)
        {
            visited[i][j]=1;
            solve(i,j+1,n,m,ans,move+"R",visited,maze);
            visited[i][j]=0;
        }
        //up
         if((i-1)>=0 && visited[i-1][j]==0 && maze[i-1][j]==1)
        {
            visited[i][j]=1;
            solve(i-1,j,n,m,ans,move+"U",visited,maze);
            visited[i][j]=0;
        }
    }
}