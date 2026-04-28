/**
 * Majority Element — Moore's Voting Algorithm
 * 
 * Problem 1: Find element appearing more than N/2 times
 * Problem 2: Find elements appearing more than N/3 times
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
import java.util.*;

public class MajorityElement {

    // Majority Element > N/2 — Boyer-Moore Voting
    public static int majorityElementHalf(int[] nums) {
        int candidate = 0, count = 0;

        // Phase 1: Find candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify (optional if guaranteed to exist)
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        return count > nums.length / 2 ? candidate : -1;
    }

    // Majority Elements > N/3 — Extended Boyer-Moore
    public static List<Integer> majorityElementThird(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Phase 1: Find two potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority (>N/2): " + majorityElementHalf(arr1)); // 2

        int[] arr2 = {3, 2, 3};
        System.out.println("Majority (>N/3): " + majorityElementThird(arr2)); // [3]

        int[] arr3 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Majority (>N/3): " + majorityElementThird(arr3)); // [1, 2]
    }
}
