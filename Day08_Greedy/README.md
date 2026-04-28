# 📅 Day 8: Greedy

## Topics Covered
1. N Meetings in One Room / Activity Selection
2. Minimum Number of Platforms Required
3. Job Sequencing Problem
4. Fractional Knapsack
5. Minimum Number of Coins (Greedy)

---

## 📝 Notes

### 1. N Meetings / Activity Selection
- **Problem**: Max meetings in one room (each has start & end time)
- **Approach**: Sort by end time, greedily pick non-overlapping meetings
- **Time**: O(n log n)

### 2. Minimum Platforms
- **Problem**: Min platforms needed so no train waits
- **Approach**: Sort arrival & departure separately, use two pointers
- **Time**: O(n log n)

### 3. Job Sequencing
- **Problem**: Each job has deadline & profit, maximize profit
- **Approach**: Sort by profit (desc), assign to latest available slot
- **Time**: O(n²) or O(n log n) with DSU

### 4. Fractional Knapsack
- **Problem**: Items with weight & value, can take fractions
- **Approach**: Sort by value/weight ratio (desc), take greedily
- **Time**: O(n log n)

### 5. Minimum Coins
- **Problem**: Minimum coins to make a given value (standard denominations)
- **Approach**: Greedy — pick largest denomination first
- **Note**: Works for standard denominations only; for arbitrary, use DP

## 🔗 Video Resources
- [N Meetings](https://www.youtube.com/watch?v=II6ziNnub1Q)
- [Min Platforms](https://www.youtube.com/watch?v=dxVcMDI7vyI)
- [Job Sequencing](https://www.youtube.com/watch?v=LjPx4wQaRIs)
- [Fractional Knapsack](https://www.youtube.com/watch?v=F_DDzYnxO14)
- [Min Coins](https://www.youtube.com/watch?v=mVg9CfJvayM)
