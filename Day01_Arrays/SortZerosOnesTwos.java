/**
 * Sort an array of 0's, 1's, and 2's — Dutch National Flag Algorithm
 * 
 * Problem: Given an array containing only 0, 1, and 2, sort it in-place
 *          without using any sorting algorithm.
 * 
 * Approach: Dutch National Flag Algorithm (3-pointer approach)
 *   - low pointer: everything before low is 0
 *   - mid pointer: current element being processed
 *   - high pointer: everything after high is 2
 *   - Elements between low and mid are 1s
 * 
 * Time Complexity: O(n) — single pass
 * Space Complexity: O(1) — in-place sorting
 * 
 * Example:
 *   Input:  [2, 0, 2, 1, 1, 0]
 *   Output: [0, 0, 1, 1, 2, 2]
 */
public class SortZerosOnesTwos {

    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid], move both pointers forward
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    // 1 is in correct position, just move mid forward
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high], only move high backward
                    // Don't increment mid — need to check swapped element
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        
        System.out.print("Before sorting: ");
        printArray(arr);
        
        sortColors(arr);
        
        System.out.print("After sorting:  ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
