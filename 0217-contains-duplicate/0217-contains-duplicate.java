class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            st.add(nums[i]);
        }
        if(nums.length==st.size())
            return false;
        else
            return true;
    }
}