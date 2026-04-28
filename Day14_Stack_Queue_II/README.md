# 📅 Day 14: Stack and Queue (Advanced)

## Topics Covered
1. Next Smaller Element
2. LRU Cache ⭐⭐ (Very Important)
3. Largest Rectangle in Histogram
4. Sliding Window Maximum
5. Implement Min Stack
6. Rotten Oranges (BFS)

---

## 📝 Notes

### 1. Next Smaller Element
- Same as NGE but use monotonic increasing stack
- **Time**: O(n)

### 2. LRU Cache ⭐⭐
- **Data Structure**: HashMap + Doubly Linked List
- **Operations**: get O(1), put O(1)
- HashMap maps key → DLL node; DLL maintains access order
- Most recently used at head, least at tail

### 3. Largest Rectangle in Histogram ⭐
- **Approach**: Monotonic stack
  - Find next smaller on left and right for each bar
  - Width = right[i] - left[i] - 1, Area = height[i] × width
- **Time**: O(n)

### 4. Sliding Window Maximum
- **Approach**: Deque (monotonic decreasing)
  - Remove smaller elements from back, remove out-of-window from front
- **Time**: O(n)

### 5. Min Stack
- **Approach**: Store (value, currentMin) pairs, or use formula: `2*val - min`
- All operations O(1)

### 6. Rotten Oranges
- **Approach**: Multi-source BFS from all rotten oranges simultaneously
- **Time**: O(m × n)
