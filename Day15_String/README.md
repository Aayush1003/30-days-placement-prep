# 📅 Day 15: String

## Topics Covered
1. Reverse Words in a String
2. Longest Palindromic Substring
3. Roman Number to Integer and Vice Versa
4. Implement ATOI / STRSTR
5. Longest Common Prefix
6. Rabin-Karp Algorithm

---

## 📝 Notes

### 1. Reverse Words
- **Approach**: Split by spaces, reverse order, join
- **In-place**: Reverse entire string, then reverse each word
- **Time**: O(n)

### 2. Longest Palindromic Substring
- **Approach**: Expand around center for each index (odd + even length)
- **Time**: O(n²)

### 3. Roman ↔ Integer
- **Roman to Int**: Map values, if current < next then subtract, else add
- **Int to Roman**: Greedy — use largest symbols first

### 4. ATOI (String to Integer)
- Handle: whitespace, sign, overflow, non-digit characters
- **Time**: O(n)

### 5. Longest Common Prefix
- **Approach**: Compare character by character across all strings
- **Time**: O(n × m) where m = shortest string length

### 6. Rabin-Karp (Pattern Matching)
- **Approach**: Rolling hash — compute hash of window, compare with pattern hash
- **Time**: O(n+m) average, O(nm) worst
