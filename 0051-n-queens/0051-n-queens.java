class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList();
        String s= ".".repeat(n);
        for(int i=0;i<n;i++)
        {
            board.add(s);
        }
        solve(0,board,ans,n);
        return ans;
    }
    private void solve(int col,List<String>board,List<List<String>> ans,int n){
        if(col==n)
        {
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row=0;row<n;row++)
        {
            if(isSafe(board,row,col,n))
            {
                String currentRow = board.get(row);
                board.set(row, currentRow.substring(0, col) + 'Q' + currentRow.substring(col + 1));
                solve(col + 1, board, ans, n);
                board.set(row, currentRow);
            }
        }
    }
    private boolean isSafe(List<String> board,int r,int c,int n)
    {
        int duprow=r;
        int dupcol=c;
        while(r>=0 && c>=0)
        {
            if(board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }
        r=duprow;
        c=dupcol;
        while(c>=0)
        {
            if(board.get(r).charAt(c)=='Q') return false;
            c--;
        }
        c=dupcol;
        while(r<n && c>=0)
        {
            if(board.get(r).charAt(c)=='Q') return false;
            r++;
            c--;
        }
        return true;
    }
}