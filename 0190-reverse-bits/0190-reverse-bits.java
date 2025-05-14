public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;           // Shift result to the left by 1 to make room
            result |= (n & 1);      // Take the last bit of n and add to result
            n >>= 1;                // Shift n to the right by 1 to process next bit
        }

        return result;  
    }
}