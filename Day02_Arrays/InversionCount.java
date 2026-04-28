/**
 * Count Inversions in an Array (Using Merge Sort)
 * 
 * Problem: Count pairs (i, j) where i < j but arr[i] > arr[j].
 * 
 * Approach: Modified Merge Sort
 *   While merging two sorted halves, if left[i] > right[j],
 *   then all remaining elements in left half form inversions with right[j].
 *   Count += (mid - i + 1)
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
import java.util.Arrays;

public class InversionCount {

    public static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;

        long count = 0;
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    private static long merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        long count = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // All elements from i to mid are greater than arr[j]
                count += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, low, temp.length);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Inversion Count: " + countInversions(arr));
        // Expected: 8 inversions → (5,3),(5,2),(5,4),(5,1),(3,2),(3,1),(2,1),(4,1)
    }
}
