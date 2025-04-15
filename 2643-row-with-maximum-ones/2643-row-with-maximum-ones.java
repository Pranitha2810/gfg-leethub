class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        int maxOnes = 0;
        for(int i=0;i<mat.length;i++)
        {
            int ones = 0;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                {
                    ones++;
                }
            }
            if(ones>maxOnes)
            {
                ans[0]=i;
                ans[1]=ones;
                maxOnes=ones;
            }
        }
        return ans;
    }
}