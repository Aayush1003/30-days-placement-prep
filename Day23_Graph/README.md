# 📅 Day 23: Graph

## Topics Covered
1. Clone a Graph
2. DFS (Depth-First Search)
3. BFS (Breadth-First Search)
4. Detect Cycle in Undirected/Directed Graph
5. Topological Sort
6. Number of Islands
7. Bipartite Check

---

## 📝 Notes

### 1. Clone Graph
- **Approach**: BFS/DFS + HashMap `{originalNode: clonedNode}`
- Create clone for each neighbor if not already cloned

### 2. DFS
- Recursive or using Stack
- **Time**: O(V + E)

### 3. BFS
- Using Queue, level by level
- **Time**: O(V + E)

### 4. Cycle Detection
- **Undirected**: DFS — if visited neighbor is not parent → cycle
- **Directed**: DFS with 3 states (unvisited, in-progress, done) — if in-progress neighbor found → cycle

### 5. Topological Sort ⭐
- Only for DAGs (Directed Acyclic Graphs)
- **Kahn's Algorithm (BFS)**: Use indegree, process nodes with indegree 0
- **DFS**: Post-order — push to stack after visiting all neighbors
- **Time**: O(V + E)

### 6. Number of Islands
- **Approach**: DFS/BFS from each unvisited land cell, mark visited
- **Time**: O(m × n)

### 7. Bipartite Check
- **Approach**: BFS/DFS coloring — try to 2-color the graph
- If any neighbor has same color → not bipartite
