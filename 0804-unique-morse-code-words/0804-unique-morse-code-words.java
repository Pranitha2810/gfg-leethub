class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> st = new HashSet<>();
        for(String word : words)
        {
            StringBuilder transformation = new StringBuilder();
            for(char ch : word.toCharArray())
            {
                transformation.append(morseCodes[ch-'a']);
            }
            st.add(transformation.toString());
        }
        return st.size();
    }
}