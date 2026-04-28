/**
 * Kadane's Algorithm — Maximum Subarray Sum
 * 
 * Problem: Find the contiguous subarray with the maximum sum.
 * 
 * Approach:
 *   - Traverse array maintaining currentSum and maxSum
 *   - Add current element to currentSum
 *   - If currentSum > maxSum, update maxSum
 *   - If currentSum < 0, reset to 0 (no point carrying negative sum forward)
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Example:
 *   Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *   Output: 6 (subarray: [4, -1, 2, 1])
 */
public class KadanesAlgorithm {

    // Returns only the maximum sum
    public static int maxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // Returns the maximum sum along with the subarray boundaries
    public static int[] maxSubarrayWithIndices(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, ansStart = 0, ansEnd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currentSum == 0) {
                start = i; // potential start of new subarray
            }

            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                ansStart = start;
                ansEnd = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return new int[]{maxSum, ansStart, ansEnd};
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Simple version
        System.out.println("Maximum Subarray Sum: " + maxSubarraySum(arr));

        // Version with subarray boundaries
        int[] result = maxSubarrayWithIndices(arr);
        System.out.println("Maximum Sum: " + result[0]);
        System.out.print("Subarray: [");
        for (int i = result[1]; i <= result[2]; i++) {
            System.out.print(arr[i]);
            if (i < result[2]) System.out.print(", ");
        }
        System.out.println("]");
    }
}
