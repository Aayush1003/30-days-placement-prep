import java.util.*;

/**
 * Day 11 — Binary Search / Divide and Conquer Problems
 */
public class BinarySearchProblems {

    // 1. N-th Root of M
    public static int nthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            long val = power(mid, n);
            if (val == m) return mid;
            else if (val > m) high = mid - 1;
            else low = mid + 1;
        }
        return -1; // No perfect nth root
    }
    private static long power(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > (long) 1e18) return (long) 1e18; // overflow guard
        }
        return result;
    }

    // 2. Single Element in Sorted Array
    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            // Before single element: pairs start at even index
            // After single element: pairs start at odd index
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1; // single element is to the right
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }

    // 3. Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    // 4. Median of Two Sorted Arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length, n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2);
            } else if (l1 > r2) high = cut1 - 1;
            else low = cut1 + 1;
        }
        return 0.0;
    }

    // 5. K-th Element of Two Sorted Arrays
    public static int kthElement(int[] a, int[] b, int k) {
        if (a.length > b.length) return kthElement(b, a, k);
        int n1 = a.length, n2 = b.length;
        int low = Math.max(0, k - n2), high = Math.min(k, n1);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
            else if (l1 > r2) high = cut1 - 1;
            else low = cut1 + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("3rd root of 27: " + nthRoot(3, 27)); // 3
        System.out.println("Single element: " + singleNonDuplicate(new int[]{1,1,2,3,3,4,4})); // 2
        System.out.println("Search rotated: " + search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println("Median: " + findMedianSortedArrays(new int[]{1,3}, new int[]{2})); // 2.0
        System.out.println("Kth element: " + kthElement(new int[]{2,3,6,7,9}, new int[]{1,4,8,10}, 5)); // 6
    }
}
