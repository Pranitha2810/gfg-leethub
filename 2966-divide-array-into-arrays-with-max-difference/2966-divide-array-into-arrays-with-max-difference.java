class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i+=3)
        {
            if((nums[i+2]-nums[i])<=k)
            {
                List<Integer> inner= new ArrayList<>();
                for(int j=i;j<=(i+2);j++)
                {
                    inner.add(nums[j]);
                }
                ans.add(inner);
            }
            else
            {
                return new int[0][0];
            }
        }
        int[][] res = new int[n/3][3];
        for(int i=0;i<n/3;i++)
        {
            for(int j=0;j<3;j++)
            {
                res[i][j]=ans.get(i).get(j);
            }
        }
        return res;
    }
}