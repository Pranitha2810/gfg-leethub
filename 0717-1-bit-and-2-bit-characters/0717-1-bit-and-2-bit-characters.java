class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        int n=bits.length;
        while(i<bits.length-1)
        {
            if(bits[i]==0)
                i++;
            else
                i+=2;
        }
        if(i==(n-1))
            return true;
        return false;
    }
}