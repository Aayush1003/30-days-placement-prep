# 📅 Day 13: Stack and Queue

## Topics Covered
1. Implement Stack / Implement Queue
2. BFS (Breadth-First Search)
3. Implement Stack using Queue
4. Implement Queue using Stack
5. Check for Balanced Parentheses
6. Next Greater Element

---

## 📝 Notes

### 1. Stack & Queue Implementation
- **Stack**: LIFO — push, pop, peek using array or linked list
- **Queue**: FIFO — enqueue, dequeue using array or linked list

### 2. BFS
- **Approach**: Use queue, visit level by level
- **Time**: O(V + E)

### 3. Stack Using Queues
- **Approach 1**: Push costly — enqueue to q2, transfer q1 to q2, swap
- **Approach 2**: Pop costly — dequeue all except last, swap
- **Approach 3**: Single queue — push, then rotate (n-1) dequeues to back

### 4. Queue Using Stacks
- **Approach 1**: Enqueue costly — transfer s1 to s2, push, transfer back
- **Approach 2**: Dequeue costly (amortized O(1)) — push to s1, pop from s2 (refill when empty)

### 5. Balanced Parentheses
- **Approach**: Stack — push opening, pop for matching closing
- **Time**: O(n)

### 6. Next Greater Element
- **Approach**: Stack (monotonic decreasing)
  - Traverse from right, pop smaller elements, top of stack is NGE
- **Time**: O(n)
