# 📅 Day 7: Two Pointer

## Topics Covered
1. Clone a Linked List with Random and Next Pointer
2. 3 Sum
3. Trapping Rainwater
4. Remove Duplicates from Sorted Array
5. Max Consecutive Ones

---

## 📝 Notes

### 1. Clone LL with Random Pointer
- **Approach**: 3-pass method
  - Pass 1: Create copy nodes interleaved: A→A'→B→B'→...
  - Pass 2: Set random pointers for copies
  - Pass 3: Separate original and cloned lists
- **Time**: O(n), **Space**: O(1) extra

### 2. Three Sum
- **Problem**: Find all triplets that sum to zero.
- **Approach**: Sort + Fix one + Two pointer for other two
- **Time**: O(n²), avoid duplicates by skipping same elements

### 3. Trapping Rainwater
- **Approach 1**: Precompute leftMax[] and rightMax[], water = min(leftMax, rightMax) - height
- **Approach 2**: Two pointers (optimal O(1) space)
- **Time**: O(n)

### 4. Remove Duplicates from Sorted Array
- **Approach**: Two pointers — place unique elements at front
- **Time**: O(n), **Space**: O(1)

### 5. Max Consecutive Ones
- **Approach**: Track current streak and max streak
- **Time**: O(n)

## 🔗 Video Resources
- [Clone LL](https://www.youtube.com/watch?v=VNf6VynfpdM)
- [3 Sum](https://www.youtube.com/watch?v=onLoX6Nhvmg)
- [Trapping Rainwater](https://www.youtube.com/watch?v=m18Hntz4go8)
- [Remove Duplicates](https://www.youtube.com/watch?v=Fm_p9lJ4Z_8)
- [Max Consecutive Ones](https://www.youtube.com/watch?v=Mo33MjjMlyA)
