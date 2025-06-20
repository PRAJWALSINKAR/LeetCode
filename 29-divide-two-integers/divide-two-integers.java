public class Solution {
    public int divide(int dividend, int divisor) {
        // Case when both are equal
        if (dividend == divisor)
            return 1;

        // Determine the sign of the result
        boolean sign = true;
        if ((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0)) {
            sign = false;
        }

        // Convert to long and take absolute value to prevent overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        // Bit manipulation division
        while (n >= d) {
            int cnt = 0;
            // Find the highest power of 2 such that (d << (cnt + 1)) <= n
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            // Add 2^cnt to result
            quotient += 1L << cnt;
            // Subtract the corresponding multiple from dividend
            n -= d << cnt;
        }

        // Handle overflow (if result exceeds int range)
        if (quotient >= (1L << 31)) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Return result with correct sign
        return sign ? (int) quotient : -(int) quotient;
    }
}
