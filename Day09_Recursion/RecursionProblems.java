import java.util.*;

/**
 * Day 9 — Recursion Problems
 */
public class RecursionProblems {

    // 1. Subset Sums
    public static List<Integer> subsetSums(int[] arr) {
        List<Integer> result = new ArrayList<>();
        subsetSumHelper(arr, 0, 0, result);
        Collections.sort(result);
        return result;
    }
    private static void subsetSumHelper(int[] arr, int idx, int sum, List<Integer> result) {
        if (idx == arr.length) { result.add(sum); return; }
        subsetSumHelper(arr, idx + 1, sum + arr[idx], result); // pick
        subsetSumHelper(arr, idx + 1, sum, result);             // not pick
    }

    // 2. Subsets II (unique subsets)
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private static void subsetsHelper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue; // skip duplicates
            curr.add(nums[i]);
            subsetsHelper(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    // 3. Combination Sum 1 (can reuse)
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combHelper1(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    private static void combHelper1(int[] arr, int idx, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) { result.add(new ArrayList<>(curr)); return; }
        if (idx == arr.length || target < 0) return;
        curr.add(arr[idx]);
        combHelper1(arr, idx, target - arr[idx], curr, result); // pick (stay)
        curr.remove(curr.size() - 1);
        combHelper1(arr, idx + 1, target, curr, result); // skip
    }

    // 4. Combination Sum 2 (each used once)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combHelper2(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    private static void combHelper2(int[] arr, int idx, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) { result.add(new ArrayList<>(curr)); return; }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            curr.add(arr[i]);
            combHelper2(arr, i + 1, target - arr[i], curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    // 5. Palindrome Partitioning
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partHelper(s, 0, new ArrayList<>(), result);
        return result;
    }
    private static void partHelper(String s, int idx, List<String> curr, List<List<String>> result) {
        if (idx == s.length()) { result.add(new ArrayList<>(curr)); return; }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                partHelper(s, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) { if (s.charAt(l++) != s.charAt(r--)) return false; }
        return true;
    }

    // 6. K-th Permutation Sequence
    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) { fact *= i; numbers.add(i); }
        numbers.add(n);
        k--; // 0-indexed
        StringBuilder sb = new StringBuilder();
        while (!numbers.isEmpty()) {
            int idx = k / fact;
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k %= fact;
            fact = numbers.isEmpty() ? 1 : fact / numbers.size();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Subset Sums: " + subsetSums(new int[]{2, 3}));
        System.out.println("Subsets II: " + subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println("CombSum1: " + combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println("CombSum2: " + combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println("Palindrome: " + partition("aab"));
        System.out.println("K-th Perm(3,3): " + getPermutation(3, 3)); // "213"
    }
}
