class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int max_score=0;
        int score=0;
        int n=tokens.length;
        int i=0;
        int j=n-1;
        Arrays.sort(tokens);
        while(i<=j)
        {
            if(power>=tokens[i])
            {
                score++;
                max_score=Math.max(max_score,score);
                power-=tokens[i];
                i++;
            }
            else if(score>=1)
            {
                score--;
                power+=tokens[j];
                j--;
            }
            else
            {
                return max_score;
            }
        }
        return max_score;
    }
}