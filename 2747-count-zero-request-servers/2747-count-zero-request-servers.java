class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->{
            if(a[1] != b[1])
            {
                return Integer.compare(a[1],b[1]);
            }
            else
            {
                return Integer.compare(a[0],b[0]);
            }
        });
        int[][] sortedQueries = new int[queries.length][2];
        for(int i=0;i<queries.length;i++)
        {
            sortedQueries[i][0]=queries[i];
            sortedQueries[i][1]=i;
        }
        Arrays.sort(sortedQueries,(a,b)->{
            if(a[0] != b[0])
            {
                return Integer.compare(a[0],b[0]);
            }
            else
            {
                return Integer.compare(a[1],b[1]);
            }
        });
        int[] ans= new int[queries.length];
        HashMap<Integer,Integer> serverCallsFreq = new HashMap<>();
        int left=0;
        int right=0;
        int serversCalled=0;
        for(int[] item : sortedQueries)
        {
            int time=item[0];
            int index = item[1];
            while(right<logs.length && logs[right][1]<=time)
            {
                if(serverCallsFreq.getOrDefault(logs[right][0],0) == 0)
                    serversCalled++;
                serverCallsFreq.put(logs[right][0],1+serverCallsFreq.getOrDefault(logs[right][0],0));
                right++;
            }
            while(left<logs.length && logs[left][1]<(time-x))
            {
                if(serverCallsFreq.getOrDefault(logs[left][0],0) == 1)
                    serversCalled--;
                 serverCallsFreq.put(logs[left][0],serverCallsFreq.getOrDefault(logs[left][0],0)-1);
                 left++;
                
            }
            ans[index]=n-serversCalled;
        }
        return ans;
    }
}