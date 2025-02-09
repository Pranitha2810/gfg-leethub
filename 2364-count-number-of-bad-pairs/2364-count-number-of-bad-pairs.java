class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> mp = new  HashMap<>();
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(mp.containsKey(nums[i]-i))
            {
                c+=mp.get(nums[i]-i);
            }
            mp.put(nums[i]-i,mp.getOrDefault(nums[i]-i,0)+1);
        }
        int t=(nums.length*(nums.length-1))/2-c;
        return t;
        
    }
}