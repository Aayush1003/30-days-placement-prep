# 📅 Day 17: Binary Tree

## Topics Covered
1. Inorder Traversal (Recursive & Iterative — Morris)
2. Preorder Traversal (Recursive & Iterative)
3. Postorder Traversal (Recursive & Iterative)
4. Left View of Binary Tree
5. Bottom View of Binary Tree
6. Top View of Binary Tree

---

## 📝 Notes

### Traversal Orders
| Traversal | Order | Mnemonic |
|-----------|-------|----------|
| Inorder | Left → Root → Right | Gives sorted order for BST |
| Preorder | Root → Left → Right | Used for serialization |
| Postorder | Left → Right → Root | Used for deletion |

### Morris Traversal (Inorder without stack/recursion)
- Uses threaded binary tree concept
- **Time**: O(n), **Space**: O(1)

### Views of Binary Tree
- **Left View**: First node at each level (BFS with level tracking)
- **Right View**: Last node at each level
- **Top View**: Nodes visible from top (BFS + vertical order, first at each column)
- **Bottom View**: Nodes visible from bottom (BFS + vertical order, last at each column)
