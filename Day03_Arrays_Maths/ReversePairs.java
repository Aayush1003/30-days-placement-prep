/**
 * Reverse Pairs
 * 
 * Problem: Count pairs (i,j) where i < j and nums[i] > 2 * nums[j].
 * 
 * Approach: Modified Merge Sort
 * Time Complexity: O(n log n)
 */
public class ReversePairs {

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = (low + high) / 2;
        int count = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);

        // Count reverse pairs
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 2L * nums[j]) j++;
            count += (j - mid - 1);
        }

        // Merge
        merge(nums, low, mid, high);
        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, low, temp.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 3, 1};
        System.out.println("Reverse Pairs: " + reversePairs(nums1)); // 2

        int[] nums2 = {2, 4, 3, 5, 1};
        System.out.println("Reverse Pairs: " + reversePairs(nums2)); // 3
    }
}
