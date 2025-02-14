class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(nums[0]!=0)
        {
            pq.add(nums[0]);
        }
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==0) continue;
            if(nums[i]!=nums[i-1])
            {
                pq.add(nums[i]);
            }
        }
        return pq.size();
    }
}