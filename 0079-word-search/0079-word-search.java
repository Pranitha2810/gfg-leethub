class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0) && find(board,i,j,0,word,m,n))
                    return true;
            }
        }
        return false;
    }
    private boolean find(char[][] board,int i,int j,int ind,String word,int m,int n)
    {
        if(ind==word.length()) return true;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]=='$') return false;
        if(board[i][j] != word.charAt(ind))
            return false;
        char temp=board[i][j];
        board[i][j]='$';
        for(int x=0;x<4;x++)
        {
            int new_i=i+directions_i[x];
            int new_j=j+directions_j[x];
            if(find(board,new_i,new_j,ind+1,word,m,n))
                return true;
        }
        board[i][j]=temp;
        return false;
        
    }
    static int[] directions_i={-1,0,+1,0};
    static int[] directions_j={0,+1,0,-1};
}