class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> l=new ArrayList<>();
        if(nums.length==0)
            return l;
        String s="";
        int start=nums[0];
        int end=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==end+1)
            {
                end=nums[i];
            }
            else
            {
                if(start==end)
                {
                    s=s+start;
                }
                else
                {
                    s=s+start;
                    s=s+"->";
                    s=s+end;
                }
                l.add(s);
                s="";
                start=nums[i];
                end=nums[i];
            }
        }
        if(start==end)
        {
            s=s+start;
        }
        else
        {
            s=s+start;
            s=s+"->";
            s=s+end;
        }
        l.add(s);
        return l;
    }
}