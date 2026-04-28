import java.util.*;

/**
 * Day 4 Hashing Problems — All 6 problems in one file
 */
public class HashingProblems {

    // ========== 1. Two Sum ==========
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // ========== 2. Four Sum ==========
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return result;
    }

    // ========== 3. Longest Consecutive Sequence ==========
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;
        for (int num : set) {
            // Only start counting from the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }

    // ========== 4. Largest Subarray with 0 Sum ==========
    public static int maxLenZeroSum(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                maxLen = i + 1;
            } else if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    // ========== 5. Count Subarrays with Given XOR ==========
    public static int countSubarraysXOR(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, prefixXOR = 0;

        for (int num : arr) {
            prefixXOR ^= num;
            if (prefixXOR == target) count++;
            count += map.getOrDefault(prefixXOR ^ target, 0);
            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
        }
        return count;
    }

    // ========== 6. Longest Substring Without Repeat ==========
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // 1. Two Sum
        System.out.println("=== Two Sum ===");
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]

        // 2. Four Sum
        System.out.println("\n=== Four Sum ===");
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

        // 3. Longest Consecutive
        System.out.println("\n=== Longest Consecutive ===");
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4

        // 4. Largest Subarray 0 Sum
        System.out.println("\n=== Largest Subarray with 0 Sum ===");
        System.out.println(maxLenZeroSum(new int[]{15, -2, 2, -8, 1, 7, 10, 23})); // 5

        // 5. Count Subarrays XOR
        System.out.println("\n=== Count Subarrays XOR ===");
        System.out.println(countSubarraysXOR(new int[]{4, 2, 2, 6, 4}, 6)); // 4

        // 6. Longest Substring No Repeat
        System.out.println("\n=== Longest Substring Without Repeat ===");
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
    }
}
