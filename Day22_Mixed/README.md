# 📅 Day 22: Mixed Questions

## Topics Covered
1. Binary Tree to Doubly Linked List
2. Find Median in a Stream of Running Integers
3. K-th Largest Element in a Stream
4. Distinct Numbers in Window
5. K-th Largest Element in Unsorted Array
6. Flood Fill Algorithm

---

## 📝 Notes

### 1. BT to DLL
- **Approach**: Inorder traversal, link previous node's right to current, current's left to previous
- **Time**: O(n)

### 2. Median in Stream ⭐
- **Data Structure**: Two heaps — maxHeap (left half) + minHeap (right half)
- Balance sizes; median = top of maxHeap or average of both tops
- **Time**: O(log n) per insertion

### 3. K-th Largest in Stream
- **Approach**: MinHeap of size K
- **Time**: O(log k) per query

### 4. Distinct in Window
- **Approach**: HashMap + sliding window
- **Time**: O(n)

### 5. K-th Largest in Unsorted Array
- **Approach 1**: MinHeap of size K → O(n log k)
- **Approach 2**: QuickSelect → O(n) average

### 6. Flood Fill
- **Approach**: BFS/DFS from starting pixel, change all connected same-color pixels
- **Time**: O(m × n)
