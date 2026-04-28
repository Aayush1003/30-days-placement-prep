# 📅 Day 1: Arrays

## Topics Covered
1. Sort an array of 0's, 1's, 2's (Dutch National Flag Algorithm)
2. Repeat and Missing Number
3. Merge two sorted arrays without extra space
4. Kadane's Algorithm (Maximum Subarray Sum)
5. Merge Overlapping Subintervals
6. Find the duplicate in an array of N+1 integers

---

## 📝 Notes

### 1. Sort 0s, 1s, 2s — Dutch National Flag Algorithm
- **Problem**: Sort an array containing only 0, 1, and 2 without using sorting algorithms or extra space.
- **Approach**: Use three pointers — `low`, `mid`, `high`
  - `arr[mid] == 0` → swap(arr[low], arr[mid]), low++, mid++
  - `arr[mid] == 1` → mid++
  - `arr[mid] == 2` → swap(arr[mid], arr[high]), high--
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)

### 2. Repeat and Missing Number
- **Problem**: In an array of N numbers from 1 to N, one number is repeated and one is missing. Find both.
- **Approach 1**: Use mathematical equations (sum and sum of squares)
  - `S - Sn = x - y` and `S2 - S2n = x² - y²`
- **Approach 2**: XOR method
  - XOR all elements and 1 to N, then separate using rightmost set bit
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)

### 3. Merge Two Sorted Arrays Without Extra Space
- **Problem**: Merge arr1[] and arr2[] in sorted order without extra space.
- **Approach (Gap Method / Shell Sort Variant)**:
  - Start with gap = ceil((n+m)/2), compare elements at gap distance
  - Reduce gap by half each iteration until gap = 0
- **Time Complexity**: O((n+m) * log(n+m))
- **Space Complexity**: O(1)

### 4. Kadane's Algorithm
- **Problem**: Find the maximum sum contiguous subarray.
- **Approach**: 
  - Maintain `currentSum` and `maxSum`
  - Add each element to `currentSum`; if `currentSum < 0`, reset to 0
  - Update `maxSum = max(maxSum, currentSum)`
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)

### 5. Merge Overlapping Subintervals
- **Problem**: Given a set of intervals, merge all overlapping intervals.
- **Approach**: 
  - Sort intervals by start time
  - Iterate: if current interval overlaps with previous, merge them
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(n) for result

### 6. Find Duplicate in Array of N+1 Integers
- **Problem**: Array of N+1 integers where each is in range [1, N]. Find the duplicate.
- **Approach (Floyd's Cycle Detection — Tortoise & Hare)**:
  - Phase 1: Find intersection point using slow and fast pointers
  - Phase 2: Find entrance of cycle (= duplicate number)
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)

---

## 🔗 Resources
- [Striver's SDE Sheet — Arrays](https://takeuforward.org/interviews/strivers-sde-sheet-top-coding-interview-problems/)
