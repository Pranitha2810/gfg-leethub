class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int i=0,j=nums.length-1;
        for(int val:nums)
        {
            if(val%2==0)
            {
                res[i++]=val;
            }
            else
                res[j--]=val;
        }
        return res;
    }
}