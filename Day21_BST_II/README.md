# 📅 Day 21: BST (Part II)

## Topics Covered
1. Floor and Ceil in BST
2. K-th Smallest and K-th Largest Element
3. Find a Pair with Given Sum in BST
4. BST Iterator
5. Size of Largest BST in Binary Tree
6. Serialize and Deserialize Binary Tree

---

## 📝 Notes

### 1. Floor and Ceil
- **Floor**: Largest value ≤ key. Go right if key > root, update floor.
- **Ceil**: Smallest value ≥ key. Go left if key < root, update ceil.
- **Time**: O(h)

### 2. K-th Smallest/Largest
- **K-th Smallest**: Inorder traversal, return k-th element
- **K-th Largest**: Reverse inorder (right → root → left)
- **Time**: O(h + k)

### 3. Pair with Sum in BST
- **Approach**: BST Iterator (two pointers — forward + backward inorder)
- **Time**: O(n), **Space**: O(h)

### 4. BST Iterator
- Simulates inorder traversal using stack
- `next()` and `hasNext()` in amortized O(1)

### 5. Largest BST in BT
- Bottom-up: each node returns {isBST, size, min, max}
- **Time**: O(n)

### 6. Serialize/Deserialize
- **Preorder** serialization with markers for null
- Deserialize using queue of values
