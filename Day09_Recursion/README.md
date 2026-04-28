# 📅 Day 9: Recursion

## Topics Covered
1. Subset Sums
2. Subset-II (Subsets with duplicates)
3. Combination Sum-1
4. Combination Sum-2
5. Palindrome Partitioning
6. K-th Permutation Sequence

---

## 📝 Notes

### 1. Subset Sums
- **Problem**: Find all possible subset sums.
- **Approach**: Pick/not-pick each element, add sum at leaf
- **Time**: O(2^n), **Space**: O(n)

### 2. Subset-II
- **Problem**: Find all unique subsets (array may have duplicates).
- **Approach**: Sort + skip duplicates at same level of recursion
- **Time**: O(2^n × n)

### 3. Combination Sum-1
- **Problem**: Find combinations that sum to target (can reuse elements).
- **Approach**: Pick (stay at index) or skip (move to next)
- **Time**: O(2^t × k) where t = target

### 4. Combination Sum-2
- **Problem**: Each number used once, find unique combinations for target.
- **Approach**: Sort + skip duplicates at same level

### 5. Palindrome Partitioning
- **Problem**: Partition string so every substring is a palindrome.
- **Approach**: Backtrack — try every prefix, if palindrome, recurse on rest

### 6. K-th Permutation Sequence
- **Problem**: Find the k-th permutation of [1,2,...,n] directly.
- **Approach**: Factorial number system — determine each digit position
- **Time**: O(n²)

## 🔗 Video Resources
- [Subset Sums](https://www.youtube.com/watch?v=rYkfBRtMJr8)
- [Subset-II](https://www.youtube.com/watch?v=RIn3gOkbhQE)
- [Combination Sum-1](https://www.youtube.com/watch?v=OyZFFqQtu98)
- [Combination Sum-2](https://www.youtube.com/watch?v=G1fRTGRxXU8)
- [Palindrome Partitioning](https://www.youtube.com/watch?v=WBgsABoClE0)
- [K-th Permutation](https://www.youtube.com/watch?v=wT7gcXLYoao)
