class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n=img.length;
        int m=img[0].length;
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans[i][j]=average(img,i,j,n,m);
            }
        }
        return ans;
    }
    static int average(int[][] img,int i,int j,int n,int m)
    {
        int count=1;
        int avg = img[i][j];
        int[] dr={-1,-1,-1,0,0,+1,+1,+1};
        int[] dc={-1,0,+1,-1,+1,-1,0,+1};
        int r=i;
        int c=j;
        for(int x=0;x<8;x++)
        {
            r=r+dr[x];
            c=c+dc[x];
            if((r>=0 && r<n) && (c>=0 && c<m))
            {
                avg+=img[r][c];
                count++;
            }
            r=i;
            c=j;
        }
        avg = avg/count;
        return avg;
    }
}