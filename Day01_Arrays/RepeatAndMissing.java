/**
 * Find the Repeat and Missing Number
 * 
 * Problem: Given an array of size N containing numbers from 1 to N,
 *          one number is repeated and one is missing. Find both.
 * 
 * Approach: Mathematical (Sum & Sum of Squares)
 *   Let x = missing number, y = repeating number
 *   S = sum of array, Sn = n*(n+1)/2
 *   S2 = sum of squares of array, S2n = n*(n+1)*(2n+1)/6
 *   
 *   x - y = Sn - S        ... (1)
 *   x² - y² = S2n - S2    ... (2)
 *   From (2)/(1): x + y = (S2n - S2) / (Sn - S)
 *   Solve for x and y.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Example:
 *   Input:  [3, 1, 2, 5, 3]  (N=5)
 *   Output: Missing = 4, Repeating = 3
 */
public class RepeatAndMissing {

    public static int[] findRepeatAndMissing(int[] arr) {
        long n = arr.length;

        // Expected sums
        long Sn = n * (n + 1) / 2;
        long S2n = n * (n + 1) * (2 * n + 1) / 6;

        // Actual sums
        long S = 0, S2 = 0;
        for (int num : arr) {
            S += num;
            S2 += (long) num * num;
        }

        // x - y = Sn - S
        long diff = Sn - S;          // missing - repeating
        // x + y = (S2n - S2) / (x - y)
        long sum = (S2n - S2) / diff; // missing + repeating

        long missing = (diff + sum) / 2;
        long repeating = sum - missing;

        return new int[]{(int) repeating, (int) missing};
    }

    // Approach 2: XOR Method
    public static int[] findUsingXOR(int[] arr) {
        int n = arr.length;
        int xor = 0;

        // XOR all array elements and 1 to N
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            xor ^= (i + 1);
        }

        // Find rightmost set bit
        int setBit = xor & (-xor);

        // Separate into two groups based on set bit
        int group0 = 0, group1 = 0;
        for (int num : arr) {
            if ((num & setBit) == 0) group0 ^= num;
            else group1 ^= num;
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) == 0) group0 ^= i;
            else group1 ^= i;
        }

        // Determine which is missing and which is repeating
        int repeating = -1, missing = -1;
        for (int num : arr) {
            if (num == group0) {
                repeating = group0;
                missing = group1;
                break;
            }
            if (num == group1) {
                repeating = group1;
                missing = group0;
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 3};

        // Method 1: Mathematical
        int[] result1 = findRepeatAndMissing(arr);
        System.out.println("Mathematical Method:");
        System.out.println("  Repeating = " + result1[0] + ", Missing = " + result1[1]);

        // Method 2: XOR
        int[] result2 = findUsingXOR(arr);
        System.out.println("XOR Method:");
        System.out.println("  Repeating = " + result2[0] + ", Missing = " + result2[1]);
    }
}
