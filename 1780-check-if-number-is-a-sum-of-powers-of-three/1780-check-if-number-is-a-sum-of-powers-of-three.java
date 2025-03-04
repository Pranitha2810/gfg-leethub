class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false; // If ternary digit is 2, return false
            n /= 3; // Reduce n by dividing by 3
        }
        return true;
    }
}