import java.util.*;

/**
 * Day 16 — Advanced String Problems (KMP, Z-Function, etc.)
 */
public class StringAdvanced {

    // 1. KMP Algorithm
    public static int kmpSearch(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) { i++; j++; }
            if (j == pattern.length()) return i - j; // Found
            else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }

    // 2. Z-Function
    public static int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) z[i] = Math.min(r - i, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
            if (i + z[i] > r) { l = i; r = i + z[i]; }
        }
        return z;
    }

    // 3. Min Characters to Make Palindrome
    public static int minCharsForPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "$" + rev;
        int[] lps = computeLPS(combined);
        return s.length() - lps[combined.length() - 1];
    }

    // 4. Check Anagrams
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int f : freq) if (f != 0) return false;
        return true;
    }

    // 5. Count and Say
    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) count++;
                else { sb.append(count).append(result.charAt(j - 1)); count = 1; }
            }
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }
        return result;
    }

    // 6. Compare Version Numbers
    public static int compareVersion(String v1, String v2) {
        String[] a = v1.split("\\."), b = v2.split("\\.");
        int maxLen = Math.max(a.length, b.length);
        for (int i = 0; i < maxLen; i++) {
            int num1 = i < a.length ? Integer.parseInt(a[i]) : 0;
            int num2 = i < b.length ? Integer.parseInt(b[i]) : 0;
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("KMP: " + kmpSearch("aabaacaadaabaaba", "aaba")); // 0
        System.out.println("Z-func: " + Arrays.toString(zFunction("aabxaab"))); // [0,1,0,0,3,1,0]
        System.out.println("Min chars palindrome 'ABC': " + minCharsForPalindrome("ABC")); // 2
        System.out.println("Anagram: " + isAnagram("listen", "silent")); // true
        System.out.println("Count&Say(5): " + countAndSay(5)); // 111221
        System.out.println("Compare 1.01 vs 1.001: " + compareVersion("1.01", "1.001")); // 0
    }
}
