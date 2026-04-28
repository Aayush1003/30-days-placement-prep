# 📅 Day 16: String (Advanced)

## Topics Covered
1. Z-Function / Prefix Function
2. KMP Algorithm ⭐
3. Minimum Characters to Make String Palindrome
4. Check for Anagrams
5. Count and Say
6. Compare Version Numbers

---

## 📝 Notes

### 1. Z-Function
- `Z[i]` = length of longest substring starting at i that matches prefix
- **Time**: O(n)

### 2. KMP Algorithm ⭐
- **Failure/LPS Array**: `lps[i]` = longest proper prefix that is also suffix
- **Matching**: On mismatch, use LPS to skip comparisons
- **Time**: O(n + m), **Space**: O(m)

### 3. Min Chars to Make Palindrome
- **Approach**: Find longest palindromic prefix using KMP
  - Concatenate: s + "$" + reverse(s), compute LPS
  - Answer: n - lps[last]

### 4. Check Anagrams
- **Approach**: Frequency count with array[26] or HashMap
- **Time**: O(n)

### 5. Count and Say
- **Sequence**: 1, 11, 21, 1211, 111221, ...
- **Approach**: Iteratively read previous term and describe it

### 6. Compare Version Numbers
- **Approach**: Split by ".", compare segment by segment
