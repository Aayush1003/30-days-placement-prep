/**
 * Next Permutation
 * 
 * Problem: Find the next lexicographically greater permutation of an array.
 *          If no such permutation exists, return the smallest permutation (sorted).
 * 
 * Algorithm:
 *   1. Find breakpoint: rightmost index i where arr[i] < arr[i+1]
 *   2. If no breakpoint found, reverse entire array (we're at last permutation)
 *   3. Find swap point: rightmost index j where arr[j] > arr[i]
 *   4. Swap arr[i] and arr[j]
 *   5. Reverse the suffix after index i
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Example: [1,2,3] → [1,3,2] → [2,1,3] → [2,3,1] → [3,1,2] → [3,2,1] → [1,2,3]
 */
import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakpoint = -1;

        // Step 1: Find the breakpoint (rightmost i where nums[i] < nums[i+1])
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse the whole array
        if (breakpoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find rightmost element greater than nums[breakpoint]
        for (int j = n - 1; j > breakpoint; j--) {
            if (nums[j] > nums[breakpoint]) {
                // Step 4: Swap
                swap(nums, breakpoint, j);
                break;
            }
        }

        // Step 5: Reverse the suffix after breakpoint
        reverse(nums, breakpoint + 1, n - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Original:        " + Arrays.toString(arr));

        // Generate all permutations in order
        for (int i = 0; i < 6; i++) {
            nextPermutation(arr);
            System.out.println("Next Permutation: " + Arrays.toString(arr));
        }
    }
}
