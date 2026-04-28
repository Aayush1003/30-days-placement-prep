# 📅 Day 20: Binary Search Tree

## Topics Covered
1. Populate Next Right Pointers
2. Search Key in BST
3. Construct BST from Given Keys
4. Validate BST
5. LCA in BST
6. Inorder Predecessor/Successor in BST

---

## 📝 Notes

### BST Property
- Left subtree < Root < Right subtree
- Inorder traversal gives sorted sequence

### 1. Next Right Pointers
- **Approach**: Level order BFS, connect nodes at same level

### 2. Search in BST
- If target < root → go left; if target > root → go right
- **Time**: O(h) where h = height

### 3. Construct BST
- Insert keys one by one, or use sorted array (balanced BST)
- **Balanced**: Find mid, make root, recurse on halves

### 4. Validate BST
- **Approach**: Pass min/max range down recursion
- Node value must be in `(min, max)` range
- **Time**: O(n)

### 5. LCA in BST
- If both values < root → go left
- If both values > root → go right
- Otherwise → current node is LCA
- **Time**: O(h)

### 6. Predecessor/Successor
- **Predecessor**: Largest in left subtree, or first ancestor where node is in right subtree
- **Successor**: Smallest in right subtree, or first ancestor where node is in left subtree
