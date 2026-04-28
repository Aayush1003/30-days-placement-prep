import java.util.*;

/**
 * Day 15 — String Problems
 */
public class StringProblems {

    // 1. Reverse Words in a String
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    // 2. Longest Palindromic Substring
    public static String longestPalindrome(String s) {
        int start = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            // Odd length
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
            if (r - l - 1 > maxLen) { maxLen = r - l - 1; start = l + 1; }
            // Even length
            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
            if (r - l - 1 > maxLen) { maxLen = r - l - 1; start = l + 1; }
        }
        return s.substring(start, start + maxLen);
    }

    // 3. Roman to Integer
    public static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                result -= map.get(s.charAt(i));
            else
                result += map.get(s.charAt(i));
        }
        return result;
    }

    // 4. Integer to Roman
    public static String intToRoman(int num) {
        int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] syms = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) { sb.append(syms[i]); num -= vals[i]; }
        }
        return sb.toString();
    }

    // 5. ATOI
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1, i = 0;
        long result = 0;
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (result * sign);
    }

    // 6. Longest Common Prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 7. Rabin-Karp Pattern Matching
    public static int rabinKarp(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        int d = 256, q = 101; // base and prime
        int h = 1, patHash = 0, txtHash = 0;
        for (int i = 0; i < m - 1; i++) h = (h * d) % q;
        for (int i = 0; i < m; i++) {
            patHash = (d * patHash + pattern.charAt(i)) % q;
            txtHash = (d * txtHash + text.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (patHash == txtHash && text.substring(i, i + m).equals(pattern))
                return i;
            if (i < n - m) {
                txtHash = (d * (txtHash - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (txtHash < 0) txtHash += q;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Reverse: '" + reverseWords("  the sky is blue  ") + "'");
        System.out.println("Palindrome: " + longestPalindrome("babad"));
        System.out.println("MCMXCIV → " + romanToInt("MCMXCIV")); // 1994
        System.out.println("1994 → " + intToRoman(1994));
        System.out.println("ATOI '   -42': " + myAtoi("   -42"));
        System.out.println("LCP: " + longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("Rabin-Karp: " + rabinKarp("hello world", "world")); // 6
    }
}
