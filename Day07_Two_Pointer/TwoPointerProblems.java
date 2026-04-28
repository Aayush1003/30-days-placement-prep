import java.util.*;

/**
 * Day 7 — Two Pointer Problems
 */
public class TwoPointerProblems {

    // 1. Three Sum
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return result;
    }

    // 2. Trapping Rainwater (Two Pointer)
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    // 3. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // 4. Max Consecutive Ones
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 1) { count++; max = Math.max(max, count); }
            else count = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("=== Three Sum ===");
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

        System.out.println("\n=== Trapping Rainwater ===");
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6

        System.out.println("\n=== Remove Duplicates ===");
        int[] arr = {1,1,2,2,3};
        System.out.println("Unique count: " + removeDuplicates(arr)); // 3

        System.out.println("\n=== Max Consecutive Ones ===");
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1})); // 3
    }
}
