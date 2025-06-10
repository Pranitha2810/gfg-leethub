class Solution {
    public int maxDifference(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp = new HashMap<>();
        int a1=0;
        int a2=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        for (Map.Entry<Character, Integer> entry : mp.entrySet()){
            if(entry.getValue()%2==1)
                a1=Math.max(a1,entry.getValue());
            else
                a2=Math.min(a2,entry.getValue());
        }
        return (a1-a2);
    }
}