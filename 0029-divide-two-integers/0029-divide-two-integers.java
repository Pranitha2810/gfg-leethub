class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the quotient
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both dividend and divisor to positive values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int quotient = 0;

        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;
            
            // Shift divisor left until it's just smaller than dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
