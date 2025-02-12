class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lengths = new int[n];
        for(int i=0;i<n;i++)
        {
            int mask=0;
            for(char ch : words[i].toCharArray())
            {
                mask |= (1<<(ch-'a'));
            }
            masks[i]=mask;
            lengths[i]=words[i].length();
        }
        int maxvalue=0;
        for(int i=0;i<n;i++)
        {
            for(int j=(i+1);j<n;j++)
            {
                if((masks[i] & masks[j]) == 0)
                {
                    maxvalue = Math.max(maxvalue,lengths[i]*lengths[j]);
                }
            }
        }
        return maxvalue;
    }
}