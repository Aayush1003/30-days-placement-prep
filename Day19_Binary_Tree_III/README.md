# 📅 Day 19: Binary Tree (Part III)

## Topics Covered
1. Maximum Path Sum
2. Construct BT from Inorder + Preorder
3. Construct BT from Inorder + Postorder
4. Symmetric Binary Tree
5. Flatten Binary Tree to LinkedList
6. Check if BT is Mirror of Itself

---

## 📝 Notes

### 1. Maximum Path Sum ⭐
- Path can start/end at any node
- At each node: maxPathSum = node.val + max(leftGain, 0) + max(rightGain, 0)
- Return: node.val + max(leftGain, rightGain, 0) (single path for parent)
- **Time**: O(n)

### 2-3. Construct BT from Traversals
- **Inorder + Preorder**: Preorder first = root, split inorder
- **Inorder + Postorder**: Postorder last = root, split inorder
- Use HashMap for O(1) index lookup in inorder
- **Time**: O(n)

### 4-6. Symmetric / Mirror
- A tree is symmetric if left subtree is mirror of right
- Mirror check: `left.val == right.val && mirror(left.left, right.right) && mirror(left.right, right.left)`
