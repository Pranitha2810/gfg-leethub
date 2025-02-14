class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<3;i++)
        {
            if(amount[i]!=0)
                pq.add(amount[i]);
        }
        int ans=0;
        while(pq.size()>1)
        {
            int x=pq.remove();
            int y=pq.remove();
            if((x-1) != 0) pq.add(x-1);
            if((y-1) != 0) pq.add(y-1);
            ans++;
        }
        if(pq.size()==1)
            ans+=pq.peek();
        return ans;
    }
}