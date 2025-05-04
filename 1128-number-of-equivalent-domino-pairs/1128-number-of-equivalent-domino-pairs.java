class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n=dominoes.length;
        int ans=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int[] domino : dominoes)
        {
            Arrays.sort(domino);
            int key = domino[0] * 10 + domino[1];
            ans+=mp.getOrDefault(key,0);
            mp.put(key,mp.getOrDefault(key,0)+1);
        }
        return ans;
    }
}