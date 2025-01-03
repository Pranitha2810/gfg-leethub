class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<candyType.length;i++)
        {
            st.add(candyType[i]);
        }
        if(st.size()<=candyType.length/2)
            return st.size();
        else
            return candyType.length/2;
    }
}