# 📅 Day 25: Dynamic Programming

## Topics Covered
1. Max Product Subarray
2. Longest Increasing Subsequence (LIS)
3. Longest Common Subsequence (LCS)
4. 0-1 Knapsack
5. Edit Distance
6. Maximum Sum Increasing Subsequence
7. Matrix Chain Multiplication

---

## 📝 Notes

### 1. Max Product Subarray
- Track maxProduct and minProduct (negative × negative = positive)
- **Time**: O(n)

### 2. LIS ⭐
- **DP**: O(n²) — for each element, check all previous
- **Binary Search**: O(n log n) — maintain sorted tails array

### 3. LCS
- **DP**: `dp[i][j] = dp[i-1][j-1]+1` if match, else `max(dp[i-1][j], dp[i][j-1])`
- **Time**: O(m × n)

### 4. 0-1 Knapsack
- **DP**: For each item, choose to include or exclude
- `dp[i][w] = max(dp[i-1][w], value[i] + dp[i-1][w-weight[i]])`
- **Space Optimization**: 1D array

### 5. Edit Distance
- Operations: Insert, Delete, Replace
- **DP**: `dp[i][j]` = min operations to convert s1[0..i] to s2[0..j]

### 6. Max Sum Increasing Subsequence
- Like LIS but track sum instead of length

### 7. Matrix Chain Multiplication (MCM) ⭐
- **DP**: Try all partition points, minimize multiplications
- `dp[i][j] = min(dp[i][k] + dp[k+1][j] + dims[i-1]*dims[k]*dims[j])`
