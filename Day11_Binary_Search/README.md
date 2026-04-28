# 📅 Day 11: Divide and Conquer / Binary Search

## Topics Covered
1. 1/N-th Root of an Integer (Binary Search)
2. Matrix Median
3. Single Element in Sorted Array
4. Search in Sorted and Rotated Array
5. Median of 2 Sorted Arrays
6. K-th Element of Two Sorted Arrays

---

## 📝 Notes

### 1. N-th Root of an Integer
- **Problem**: Find N-th root of M (floor value)
- **Approach**: Binary Search on answer space [1, M]
  - Mid^N == M → found; Mid^N > M → search left; else search right
- **Time**: O(N × log(M))

### 2. Matrix Median
- **Problem**: Find median of row-wise sorted matrix (odd elements)
- **Approach**: Binary search on value range [min, max]
  - Count elements ≤ mid in each row using upper_bound
  - If count ≤ n*m/2 → search right; else search left
- **Time**: O(32 × n × log(m))

### 3. Single Element in Sorted Array
- **Problem**: Every element appears twice except one. Find it.
- **Approach**: Binary Search on indices
  - Before single element: first occurrence at even index
  - After single element: first occurrence at odd index
- **Time**: O(log n)

### 4. Search in Rotated Sorted Array
- **Problem**: Search target in a rotated sorted array.
- **Approach**: Modified Binary Search
  - Find which half is sorted, check if target lies in sorted half
- **Time**: O(log n)

### 5. Median of Two Sorted Arrays ⭐
- **Problem**: Find median of two sorted arrays in O(log(min(m,n)))
- **Approach**: Binary search on partition of smaller array
  - Partition both arrays such that left half ≤ right half
- **Time**: O(log(min(m,n)))

### 6. K-th Element of Two Sorted Arrays
- **Problem**: Find k-th smallest element from two sorted arrays
- **Approach**: Similar to median — binary search on partition
- **Time**: O(log(min(m,n)))
