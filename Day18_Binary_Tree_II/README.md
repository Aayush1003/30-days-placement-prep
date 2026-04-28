# 📅 Day 18: Binary Tree (Part II)

## Topics Covered
1. Level Order Traversal / Spiral Form
2. Height of a Binary Tree
3. Diameter of Binary Tree
4. Check if Height Balanced
5. LCA (Lowest Common Ancestor)
6. Check if Two Trees are Identical

---

## 📝 Notes

### 1. Level Order Traversal
- **BFS with Queue** — process level by level
- **Spiral**: Use flag to alternate direction or deque
- **Time**: O(n)

### 2. Height of Binary Tree
- `height = 1 + max(height(left), height(right))`
- **Time**: O(n)

### 3. Diameter
- Longest path between any two nodes (may/may not pass through root)
- At each node: `diameter = leftHeight + rightHeight`
- **Time**: O(n) with single-pass approach

### 4. Height Balanced
- A tree is balanced if `|leftHeight - rightHeight| <= 1` at every node
- Return -1 if unbalanced (early termination)
- **Time**: O(n)

### 5. LCA ⭐
- If both p and q are found in different subtrees → current node is LCA
- If both in same subtree → recurse into that subtree
- **Time**: O(n)

### 6. Identical Trees
- Both null → true; one null → false; values equal → recurse both children
- **Time**: O(n)
