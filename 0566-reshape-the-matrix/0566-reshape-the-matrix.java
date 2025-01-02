class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row=mat.length;
        int col=mat[0].length;
        if(row*col != r*c)
            return mat;
        int[][] newmat=new int[r][c];
        int i=0,j=0;
        for(int p=0;p<row;p++)
        {
            for(int q=0;q<col;q++)
            {
                newmat[i][j]=mat[p][q];
                j++;
                if(j==c)
                {
                    j=j%c;
                    i++;
                }
            }
        }
        return newmat;
    }
}