# 📅 Day 5: Linked List

## Topics Covered
1. Reverse a LinkedList
2. Find Middle of LinkedList
3. Merge Two Sorted Linked Lists
4. Remove N-th Node from Back
5. Delete a Given Node (O(1) solution)
6. Add Two Numbers as LinkedList

---

## 📝 Notes

### 1. Reverse a LinkedList
- **Approach (Iterative)**: Use three pointers — prev, current, next
  - Save next, point current to prev, advance prev and current
- **Approach (Recursive)**: Reverse rest, then link
- **Time**: O(n), **Space**: O(1) iterative / O(n) recursive

### 2. Find Middle of LinkedList
- **Approach**: Slow & Fast pointer (tortoise & hare)
  - slow moves 1 step, fast moves 2 steps
  - When fast reaches end, slow is at middle
- **Time**: O(n), **Space**: O(1)

### 3. Merge Two Sorted Linked Lists
- **Approach**: Compare nodes, attach smaller one to result
- **Time**: O(n + m), **Space**: O(1)

### 4. Remove N-th Node from Back
- **Approach**: Two pointers with gap of N
  - Move fast N steps ahead, then move both until fast reaches end
- **Time**: O(length), **Space**: O(1)

### 5. Delete a Given Node (O(1))
- **Key Insight**: Copy next node's value to current, then delete next
- **Time**: O(1), **Space**: O(1)

### 6. Add Two Numbers as LinkedList
- **Problem**: Numbers stored in reverse order, add and return sum as LL
- **Approach**: Traverse both, sum with carry, create new nodes
- **Time**: O(max(m,n)), **Space**: O(max(m,n))

---

## 🔗 Video Resources
- [Reverse LL](https://www.youtube.com/watch?v=iRtLEoL-r-g)
- [Find Middle](https://www.youtube.com/watch?v=sGdwSH8RK-o)
- [Merge Sorted LL](https://www.youtube.com/watch?v=Xb4slcp1U38)
- [Remove Nth from Back](https://www.youtube.com/watch?v=Lhu3MsXZy-Q)
- [Delete Node O(1)](https://www.youtube.com/watch?v=icnp4FJdZ_c)
- [Add Two Numbers](https://www.youtube.com/watch?v=LBVsXSMOIk4)
