# 📅 Day 3: Arrays / Maths

## Topics Covered
1. Search in a 2D Matrix
2. Pow(x, n)
3. Majority Element (>N/2 times) — Moore's Voting Algorithm
4. Majority Element (>N/3 times)
5. Grid Unique Paths
6. Reverse Pairs (Leetcode)

---

## 📝 Notes

### 1. Search in a 2D Matrix
- **Problem**: Search for a target in a row-wise and column-wise sorted matrix.
- **Approach**: Treat 2D matrix as a virtual 1D sorted array
  - `row = mid / cols`, `col = mid % cols`
- **Time Complexity**: O(log(m×n))

### 2. Pow(x, n)
- **Problem**: Calculate x raised to the power n.
- **Approach**: Binary Exponentiation
  - If n is even: `x^n = (x²)^(n/2)`
  - If n is odd: `x^n = x * (x²)^((n-1)/2)`
- **Time Complexity**: O(log n)

### 3. Majority Element (>N/2) — Moore's Voting Algorithm
- **Problem**: Find element appearing more than N/2 times.
- **Approach**: 
  - Phase 1: Find candidate (increment/decrement count)
  - Phase 2: Verify candidate
- **Time Complexity**: O(n), Space: O(1)

### 4. Majority Element (>N/3)
- **Problem**: Find all elements appearing more than N/3 times.
- **Key Insight**: At most 2 such elements can exist
- **Approach**: Extended Boyer-Moore (track two candidates)
- **Time Complexity**: O(n)

### 5. Grid Unique Paths
- **Problem**: Count unique paths from top-left to bottom-right in m×n grid.
- **Approach**: Combinatorics → `C(m+n-2, m-1)` or DP
- **Time Complexity**: O(m-1) or O(m×n)

### 6. Reverse Pairs
- **Problem**: Count pairs (i,j) where `i < j` and `arr[i] > 2*arr[j]`.
- **Approach**: Modified Merge Sort (similar to inversion count)
- **Time Complexity**: O(n log n)

---

## 🔗 Video Resources
- [Search 2D Matrix](https://www.youtube.com/watch?v=ZYpYur0znng)
- [Pow(x,n)](https://www.youtube.com/watch?v=l0YC3876qxg)
- [Majority Element N/2](https://www.youtube.com/watch?v=AoX3BPWNnoE)
- [Majority Element N/3](https://www.youtube.com/watch?v=yDbkQd9t2ig)
- [Grid Unique Paths](https://www.youtube.com/watch?v=t_f0nwwdg5o)
- [Reverse Pairs](https://www.youtube.com/watch?v=S6rsAlj_iB4)
