class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int N=n*n;
        int sn=(N*(N+1))/2;
        int s2n=(N*(N+1)*(2*N+1))/6;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum1+=grid[i][j];
                sum2+=grid[i][j]*grid[i][j];
            }
        }
        int val1=sn-sum1;
        int val2=s2n-sum2;
        val2=val2/val1;
        int x=(val1+val2)/2;
        int y=x-val1;
        return new int[]{y,x};
    }
}