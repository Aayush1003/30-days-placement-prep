# 📅 Day 4: Hashing

## Topics Covered
1. 2 Sum Problem
2. 4 Sum Problem
3. Longest Consecutive Sequence
4. Largest Subarray with 0 Sum
5. Count Subarrays with Given XOR
6. Longest Substring Without Repeating Characters

---

## 📝 Notes

### 1. Two Sum
- **Problem**: Find two numbers that add up to a target.
- **Approach**: HashMap storing `{value: index}`
- **Time**: O(n), **Space**: O(n)

### 2. Four Sum
- **Problem**: Find all unique quadruplets that sum to target.
- **Approach**: Sort + fix two elements + two-pointer for remaining
- **Time**: O(n³), **Space**: O(1) extra

### 3. Longest Consecutive Sequence
- **Problem**: Find length of longest consecutive sequence.
- **Approach**: HashSet — for each num, check if `num-1` exists (start of sequence)
- **Time**: O(n), **Space**: O(n)

### 4. Largest Subarray with 0 Sum
- **Problem**: Find length of longest subarray with sum = 0.
- **Approach**: Prefix sum + HashMap `{prefixSum: firstIndex}`
- **Key Insight**: If same prefix sum appears at i and j, subarray [i+1...j] has sum 0
- **Time**: O(n)

### 5. Count Subarrays with Given XOR
- **Problem**: Count subarrays with XOR equal to target.
- **Approach**: Prefix XOR + HashMap `{prefixXOR: count}`
  - `count += map.get(prefixXOR ^ target)`
- **Time**: O(n)

### 6. Longest Substring Without Repeat
- **Problem**: Find longest substring without repeating characters.
- **Approach**: Sliding Window + HashMap `{char: lastIndex}`
- **Time**: O(n)

---

## 🔗 Video Resources
- [2 Sum](https://www.youtube.com/watch?v=dRUpbt8vHpo)
- [4 Sum](https://www.youtube.com/watch?v=4ggF3tXIAp0)
- [Longest Consecutive Sequence](https://www.youtube.com/watch?v=qgizvmgeyUM)
- [Largest Subarray 0 Sum](https://www.youtube.com/watch?v=xmguZ6GbatA)
- [Subarrays with XOR](https://www.youtube.com/watch?v=lO9R5CaGRPY)
- [Longest Substring No Repeat](https://www.youtube.com/watch?v=qtVh-XEpsJo)
