class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        if(n==1 && m==1)
            return 0;
         int size = n * m;
        int[] arr = new int[size];
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }
        Arrays.sort(arr);
        int median = arr[size / 2];
        int ans=0;
        for(int num : arr)
        {  
            if(Math.abs(num-median)%x != 0)
                return -1;
            ans+=Math.abs(num-median)/x;
        }
        return ans;
    }
}