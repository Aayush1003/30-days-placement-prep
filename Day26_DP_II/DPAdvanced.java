import java.util.*;

/**
 * Day 26 — Dynamic Programming Part II
 */
public class DPAdvanced {

    // 1. Max Sum Path in Matrix
    public static int maxPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) grid[i][0] += grid[i-1][0];
        for (int j = 1; j < n; j++) grid[0][j] += grid[0][j-1];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
        return grid[m-1][n-1];
    }

    // 2. Coin Change (Min coins)
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int coin : coins)
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 3. Subset Sum
    public static boolean subsetSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums)
            for (int j = target; j >= num; j--)
                dp[j] = dp[j] || dp[j - num];
        return dp[target];
    }

    // 4. Rod Cutting
    public static int rodCutting(int[] prices, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] = Math.max(dp[i], prices[j] + dp[i - j - 1]);
        return dp[n];
    }

    // 5. Egg Dropping
    public static int eggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 1; i <= eggs; i++)
            for (int j = 1; j <= floors; j++) {
                if (i == 1) { dp[i][j] = j; continue; }
                dp[i][j] = Integer.MAX_VALUE;
                int lo = 1, hi = j;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    int breaks = dp[i-1][mid-1]; // egg breaks
                    int survives = dp[i][j-mid]; // egg survives
                    int worst = 1 + Math.max(breaks, survives);
                    dp[i][j] = Math.min(dp[i][j], worst);
                    if (breaks > survives) hi = mid - 1;
                    else lo = mid + 1;
                }
            }
        return dp[eggs][floors];
    }

    // 6. Word Break
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && dict.contains(s.substring(j, i))) { dp[i] = true; break; }
        return dp[s.length()];
    }

    // 7. Palindrome Partitioning (Min Cuts)
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        int[] dp = new int[n]; // dp[i] = min cuts for s[0..i]
        for (int i = 0; i < n; i++) {
            int minCuts = i; // max cuts needed
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || isPalin[j+1][i-1])) {
                    isPalin[j][i] = true;
                    minCuts = (j == 0) ? 0 : Math.min(minCuts, dp[j-1] + 1);
                }
            }
            dp[i] = minCuts;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Coin Change: " + coinChange(new int[]{1,5,11}, 11)); // 1
        System.out.println("Subset Sum: " + subsetSum(new int[]{3,34,4,12,5,2}, 9)); // true
        System.out.println("Rod Cutting: " + rodCutting(new int[]{1,5,8,9,10,17,17,20}, 8)); // 22
        System.out.println("Egg Drop(2,10): " + eggDrop(2, 10)); // 4
        System.out.println("Word Break: " + wordBreak("leetcode", Arrays.asList("leet","code"))); // true
        System.out.println("Min Cuts 'aab': " + minCut("aab")); // 1
    }
}
