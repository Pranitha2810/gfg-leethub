class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int n=tickets.length;
        for(int i=0;i<n;i++)
        {
            q.offer(i);
        }
        int ans=0;
        while(!q.isEmpty())
        {
            int ind = q.remove();
            tickets[ind]--;
            ans++;
            if(tickets[ind]==0 && k==ind)
            {
                return ans;
            }
            if(tickets[ind]!=0)
            {
                q.offer(ind);
            }
        }
        return ans;
    }
}