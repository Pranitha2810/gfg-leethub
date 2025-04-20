class Solution {
    public int numRabbits(int[] answers) {
        int ans=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int ele : answers)
        {
            if(ele == 0)
            {
                ans+=1;
            }
            else
            {
                mp.put(ele,1+mp.getOrDefault(ele,0));
                if(mp.get(ele)==ele+1)
                {
                    ans+=(ele+1);
                    mp.put(ele,0);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 0) {
                ans += (entry.getKey() + 1);
             }
        }

        return ans;
    }
}