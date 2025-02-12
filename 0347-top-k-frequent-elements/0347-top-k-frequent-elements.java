class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int val:nums)
        {
            mp.put(val,mp.getOrDefault(val,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->
            b.getValue() - a.getValue());
        pq.addAll(mp.entrySet());
        int[] ans = new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.poll().getKey();
        }
        return ans;
    }
}