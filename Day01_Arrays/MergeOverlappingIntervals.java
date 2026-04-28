/**
 * Merge Overlapping Subintervals
 * 
 * Problem: Given an array of intervals, merge all overlapping intervals.
 * 
 * Approach:
 *   1. Sort intervals by start time
 *   2. For each interval:
 *      - If it overlaps with the last merged interval, merge them
 *      - Otherwise, add it as a new interval
 * 
 * Time Complexity: O(n log n) — due to sorting
 * Space Complexity: O(n) — for result list
 * 
 * Example:
 *   Input:  [[1,3], [2,6], [8,10], [15,18]]
 *   Output: [[1,6], [8,10], [15,18]]
 */
import java.util.*;

public class MergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] curr = intervals[i];

            if (curr[0] <= last[1]) {
                // Overlapping — merge by extending end time
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // Non-overlapping — add new interval
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println("Before merging:");
        for (int[] interval : intervals) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();

        int[][] merged = merge(intervals);

        System.out.println("After merging:");
        for (int[] interval : merged) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }
}
