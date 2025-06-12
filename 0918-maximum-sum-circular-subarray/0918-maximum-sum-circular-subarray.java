class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        // find maxsubarray sum ,minsubarray sum, total sum in  original array in one pass using kadanes
        int total=0;
        int temp_maxSum=0;
        int maxSum = Integer.MIN_VALUE;
        int temp_minSum=0;
        int minSum=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            //maxsubarray sum
            temp_maxSum=Math.max(temp_maxSum+arr[i],arr[i]);
            maxSum=Math.max(maxSum,temp_maxSum);
            //minsubarray sum
            temp_minSum=Math.min(temp_minSum+arr[i],arr[i]);
            minSum=Math.min(minSum,temp_minSum);
            //total sum
            total+=arr[i];
        }
        if(total==minSum)
            return maxSum;
        int circular_sum=(total-minSum);
        return Math.max(maxSum,circular_sum);
    }
}