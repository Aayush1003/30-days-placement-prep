/**
 * Find the Duplicate in an Array of N+1 Integers
 * 
 * Problem: Given an array of N+1 integers where each integer is in [1, N],
 *          find the one duplicate number.
 * 
 * Approach: Floyd's Cycle Detection (Tortoise and Hare)
 *   - Treat array as a linked list where arr[i] points to arr[arr[i]]
 *   - Phase 1: Find intersection point of slow and fast pointers
 *   - Phase 2: Find entrance of the cycle (= duplicate)
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Example:
 *   Input:  [1, 3, 4, 2, 2]
 *   Output: 2
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];        // Move one step
            fast = nums[nums[fast]];   // Move two steps
        } while (slow != fast);

        // Phase 2: Find entry point of cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // The duplicate number
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 2, 2};
        System.out.println("Array: [1, 3, 4, 2, 2]");
        System.out.println("Duplicate: " + findDuplicate(arr1)); // Output: 2

        int[] arr2 = {3, 1, 3, 4, 2};
        System.out.println("\nArray: [3, 1, 3, 4, 2]");
        System.out.println("Duplicate: " + findDuplicate(arr2)); // Output: 3
    }
}
