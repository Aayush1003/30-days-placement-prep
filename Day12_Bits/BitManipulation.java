import java.util.*;

/**
 * Day 12 — Bit Manipulation Problems
 */
public class BitManipulation {

    // 1. Check Power of 2
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 2. Count Set Bits (Brian Kernighan's)
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1); // Remove last set bit
            count++;
        }
        return count;
    }

    // 3. Divide Without / Operator
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
        int quotient = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << (shift + 1))) shift++;
            quotient += (1 << shift);
            a -= (b << shift);
        }
        return negative ? -quotient : quotient;
    }

    // 4. Power Set (Generate All Subsets)
    public static List<List<Integer>> powerSet(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    // 5. Find MSB Position
    public static int findMSB(int n) {
        return Integer.highestOneBit(n);
    }

    // 6. Square Without * or /
    public static int square(int n) {
        if (n < 0) n = -n;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += n; // Adding n, n times = n*n
        }
        return result;
    }

    // Alternative: Using bit shifts
    public static int squareBitwise(int n) {
        if (n < 0) n = -n;
        int result = 0;
        int temp = n;
        int i = 0;
        while (temp > 0) {
            if ((temp & 1) == 1) {
                result += (n << i);
            }
            temp >>= 1;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("16 is power of 2: " + isPowerOfTwo(16));  // true
        System.out.println("Set bits in 7: " + countSetBits(7));       // 3
        System.out.println("10 / 3 = " + divide(10, 3));              // 3
        System.out.println("Power Set {1,2,3}: " + powerSet(new int[]{1, 2, 3}));
        System.out.println("MSB of 10: " + findMSB(10));              // 8
        System.out.println("Square of 5: " + square(5));               // 25
        System.out.println("Square (bitwise) of 7: " + squareBitwise(7)); // 49
    }
}
