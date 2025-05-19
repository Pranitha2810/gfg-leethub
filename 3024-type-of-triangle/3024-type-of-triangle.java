class Solution {
    public String triangleType(int[] nums) {
        if(!isvalid(nums)) return "none";
        HashSet<Integer> st = new HashSet<>();
        st.add(nums[0]);
        st.add(nums[1]);
        st.add(nums[2]);
        if(st.size()==1) return "equilateral";
        else if(st.size()==3) return "scalene";
        return "isosceles";
    }
    static boolean isvalid(int[] a)
    {
        if((a[0]+a[1]<=a[2]) ||(a[0]+a[2]<=a[1]) || (a[1]+a[2]<=a[0]))
            return false;
        return true;
    }
}