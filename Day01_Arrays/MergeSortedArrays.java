/**
 * Merge Two Sorted Arrays Without Extra Space
 * 
 * Problem: Given two sorted arrays arr1[] and arr2[], merge them
 *          such that arr1[] contains the first n smallest elements 
 *          and arr2[] contains the remaining m elements in sorted order.
 * 
 * Approach: Gap Method (based on Shell Sort)
 *   - Start with gap = ceil((n+m)/2)
 *   - Compare elements at gap distance, swap if needed
 *   - Reduce gap by half until gap = 0
 * 
 * Time Complexity: O((n+m) * log(n+m))
 * Space Complexity: O(1)
 * 
 * Example:
 *   Input:  arr1 = [1, 3, 5, 7], arr2 = [0, 2, 6, 8, 9]
 *   Output: arr1 = [0, 1, 2, 3], arr2 = [5, 6, 7, 8, 9]
 */
import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0;

            // Compare within arr1
            for (; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    swap(arr1, i, i + gap);
                }
            }

            // Compare arr1 and arr2
            int j = gap > n ? gap - n : 0;
            for (; i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            // Compare within arr2
            if (j < m) {
                for (int k = 0; k + gap < m; k++) {
                    if (arr2[k] > arr2[k + gap]) {
                        swap(arr2, k, k + gap);
                    }
                }
            }

            gap = nextGap(gap);
        }

        // Final sort to ensure correctness
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Simpler Approach: Compare and swap from ends
    public static void mergeSimple(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;

        // Compare last element of arr1 with first element of arr2
        for (int i = n - 1; i >= 0; i--) {
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                // Re-sort arr2 using insertion sort logic
                int first = arr2[0];
                int k;
                for (k = 1; k < m && arr2[k] < first; k++) {
                    arr2[k - 1] = arr2[k];
                }
                arr2[k - 1] = first;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        System.out.println("Before merge:");
        System.out.println("  arr1 = " + Arrays.toString(arr1));
        System.out.println("  arr2 = " + Arrays.toString(arr2));

        mergeSimple(arr1, arr2);

        System.out.println("After merge:");
        System.out.println("  arr1 = " + Arrays.toString(arr1));
        System.out.println("  arr2 = " + Arrays.toString(arr2));
    }
}
