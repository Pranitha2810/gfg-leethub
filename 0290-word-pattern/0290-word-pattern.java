class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        if(pattern.length()!=words.length)
            return false;
        HashMap<Character,String> charToword = new HashMap<>();
        HashMap<String,Character> wordTochar = new HashMap<>();
        for(int i=0;i<pattern.length();i++)
        {
            char c=pattern.charAt(i);
            String word=words[i];
            if(charToword.containsKey(c))
            {
                if(!charToword.get(c).equals(word))
                    return false;
            }
            else
                charToword.put(c,word);
            if(wordTochar.containsKey(word))
            {
                if(!wordTochar.get(word).equals(c))
                {
                    return false;
                }
            }
            else
                wordTochar.put(word,c);
        }
        return true;
    }
}