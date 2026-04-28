import java.util.*;

/**
 * Day 8 — Greedy Problems
 */
public class GreedyProblems {

    // 1. N Meetings in One Room
    public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][3];
        for (int i = 0; i < n; i++) meetings[i] = new int[]{start[i], end[i], i};
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]); // sort by end time
        int count = 1, lastEnd = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > lastEnd) { count++; lastEnd = meetings[i][1]; }
        }
        return count;
    }

    // 2. Minimum Platforms
    public static int minPlatforms(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int plat = 0, maxPlat = 0, i = 0, j = 0;
        while (i < arrival.length) {
            if (arrival[i] <= departure[j]) { plat++; i++; }
            else { plat--; j++; }
            maxPlat = Math.max(maxPlat, plat);
        }
        return maxPlat;
    }

    // 3. Job Sequencing
    public static int[] jobSequencing(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]); // sort by profit desc
        int maxDeadline = 0;
        for (int[] job : jobs) maxDeadline = Math.max(maxDeadline, job[1]);
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);
        int count = 0, profit = 0;
        for (int[] job : jobs) {
            for (int j = job[1]; j >= 1; j--) {
                if (slot[j] == -1) {
                    slot[j] = job[0];
                    count++; profit += job[2];
                    break;
                }
            }
        }
        return new int[]{count, profit};
    }

    // 4. Fractional Knapsack
    public static double fractionalKnapsack(int W, int[][] items) {
        // items[i] = {value, weight}
        Arrays.sort(items, (a, b) -> Double.compare((double)b[0]/b[1], (double)a[0]/a[1]));
        double totalValue = 0;
        for (int[] item : items) {
            if (W >= item[1]) { totalValue += item[0]; W -= item[1]; }
            else { totalValue += (double) item[0] * W / item[1]; break; }
        }
        return totalValue;
    }

    // 5. Minimum Coins
    public static int minCoins(int amount) {
        int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int count = 0;
        for (int coin : coins) {
            count += amount / coin;
            amount %= coin;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== N Meetings ===");
        System.out.println(maxMeetings(new int[]{1,3,0,5,8,5}, new int[]{2,4,6,7,9,9})); // 4

        System.out.println("\n=== Min Platforms ===");
        System.out.println(minPlatforms(new int[]{900,940,950,1100,1500,1800}, 
                                        new int[]{910,1200,1120,1130,1900,2000})); // 3

        System.out.println("\n=== Job Sequencing ===");
        int[][] jobs = {{1,4,20},{2,1,10},{3,1,40},{4,1,30}};
        System.out.println(Arrays.toString(jobSequencing(jobs))); // [2, 60]

        System.out.println("\n=== Fractional Knapsack ===");
        int[][] items = {{60,10},{100,20},{120,30}};
        System.out.println(fractionalKnapsack(50, items)); // 240.0

        System.out.println("\n=== Min Coins for 49 ===");
        System.out.println(minCoins(49)); // 7 (20+20+5+2+2)
    }
}
