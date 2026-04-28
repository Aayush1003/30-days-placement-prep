# 📅 Day 26: Dynamic Programming (Part II)

## Topics Covered
1. Maximum Sum Path in Matrix
2. Coin Change
3. Subset Sum
4. Rod Cutting
5. Egg Dropping
6. Word Break
7. Palindrome Partitioning (MCM Variation)
8. Maximum Profit in Job Scheduling

---

## 📝 Notes

### 1. Max Sum Path in Matrix
- **DP**: `dp[i][j] = grid[i][j] + max(dp[i-1][j], dp[i][j-1])`
- **Time**: O(m × n)

### 2. Coin Change ⭐
- **Problem**: Min coins to make amount
- **DP**: `dp[i] = min(dp[i], dp[i - coin] + 1)` for each coin
- **Time**: O(amount × coins)

### 3. Subset Sum
- **Problem**: Does any subset sum to target?
- **DP**: `dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i]]`

### 4. Rod Cutting
- Like unbounded knapsack — maximize revenue from cutting rod
- **DP**: `dp[i] = max(price[j] + dp[i-j-1])` for all j < i

### 5. Egg Dropping ⭐
- **Problem**: Min attempts to find critical floor with K eggs and N floors
- **DP + Binary Search**: O(K × N × log N)

### 6. Word Break
- **DP**: `dp[i] = true` if s[0..i] can be segmented into dictionary words

### 7. Palindrome Partitioning (MCM)
- **DP**: `dp[i][j]` = min cuts to make s[i..j] all palindromes

### 8. Job Scheduling
- Sort by end time, binary search for last non-conflicting job
- **DP**: `dp[i] = max(dp[i-1], profit[i] + dp[lastNonConflict])`
