class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1) return word;
        String res = "";
        int n = word.length();
        int max_length = n - numFriends + 1;
        for (int s = 0; s < n; s++) {
            int e = Math.min(n, s + max_length); // fix to ensure valid end index
            String sub = word.substring(s, e);
            if (res.compareTo(sub) < 0) {
                res = sub;
            }
        }
        return res;
    }
}
