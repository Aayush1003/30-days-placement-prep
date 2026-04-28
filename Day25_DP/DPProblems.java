import java.util.*;

/**
 * Day 25 — Dynamic Programming Problems
 */
public class DPProblems {

    // 1. Max Product Subarray
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) { int t = maxProd; maxProd = minProd; minProd = t; }
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);
            result = Math.max(result, maxProd);
        }
        return result;
    }

    // 2. LIS (Binary Search O(n log n))
    public static int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(tails, num);
            if (pos < 0) pos = -(pos + 1);
            if (pos == tails.size()) tails.add(num);
            else tails.set(pos, num);
        }
        return tails.size();
    }

    // 3. LCS
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = s1.charAt(i-1) == s2.charAt(j-1) ? dp[i-1][j-1]+1 : Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[m][n];
    }

    // 4. 0-1 Knapsack (Space Optimized)
    public static int knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++)
            for (int w = W; w >= weights[i]; w--)
                dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
        return dp[W];
    }

    // 5. Edit Distance
    public static int editDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        return dp[m][n];
    }

    // 6. Matrix Chain Multiplication
    public static int mcm(int[] dims) {
        int n = dims.length - 1;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++)
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + dims[i]*dims[k+1]*dims[j+1]);
            }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Max Product: " + maxProduct(new int[]{2,3,-2,4})); // 6
        System.out.println("LIS: " + lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // 4
        System.out.println("LCS: " + longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println("Knapsack: " + knapsack(50, new int[]{10,20,30}, new int[]{60,100,120})); // 220
        System.out.println("Edit Dist: " + editDistance("horse", "ros")); // 3
        System.out.println("MCM: " + mcm(new int[]{10, 20, 30, 40, 30})); // 30000
    }
}
