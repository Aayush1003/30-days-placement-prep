/**
 * Grid Unique Paths
 * 
 * Problem: Count unique paths from (0,0) to (m-1,n-1). Only move right or down.
 * 
 * Approach 1: Combinatorics → C(m+n-2, m-1)
 * Approach 2: DP
 * 
 * Time: O(min(m,n)) for combinatorics, O(m×n) for DP
 */
public class GridUniquePaths {

    // Approach 1: Combinatorics
    public static int uniquePaths(int m, int n) {
        int totalSteps = m + n - 2;
        int r = Math.min(m - 1, n - 1);
        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (totalSteps - r + i) / i;
        }

        return (int) result;
    }

    // Approach 2: DP
    public static int uniquePathsDP(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Grid 3x7 paths (Combinatorics): " + uniquePaths(3, 7)); // 28
        System.out.println("Grid 3x7 paths (DP): " + uniquePathsDP(3, 7));          // 28
        System.out.println("Grid 3x3 paths: " + uniquePaths(3, 3));                  // 6
    }
}
