/**
 * Pow(x, n) — Binary Exponentiation
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class PowXN {

    public static double myPow(double x, int n) {
        double result = 1.0;
        long nn = n; // Handle Integer.MIN_VALUE

        if (nn < 0) nn = -nn;

        while (nn > 0) {
            if (nn % 2 == 1) {
                result *= x;
                nn--;
            } else {
                x *= x;
                nn /= 2;
            }
        }

        return n < 0 ? 1.0 / result : result;
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " + myPow(2, 10));    // 1024.0
        System.out.println("2^-2 = " + myPow(2, -2));    // 0.25
        System.out.println("3^5 = " + myPow(3, 5));      // 243.0
    }
}
