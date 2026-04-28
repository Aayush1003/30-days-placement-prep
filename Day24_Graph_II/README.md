# 📅 Day 24: Graph (Part II)

## Topics Covered
1. SCC — Kosaraju's Algorithm
2. Dijkstra's Algorithm
3. Bellman-Ford Algorithm
4. Floyd-Warshall Algorithm
5. MST — Prim's Algorithm
6. MST — Kruskal's Algorithm

---

## 📝 Notes

### 1. Strongly Connected Components (Kosaraju's)
1. Do DFS and push to stack by finish time
2. Transpose the graph
3. Process nodes in stack order, do DFS on transposed graph
- **Time**: O(V + E)

### 2. Dijkstra's ⭐ (Single Source Shortest Path)
- **Constraint**: Non-negative weights only
- **Approach**: Priority Queue (min-heap), relax edges greedily
- **Time**: O((V + E) log V) with priority queue

### 3. Bellman-Ford (handles negative weights)
- Relax all edges V-1 times
- Detect negative cycle on V-th relaxation
- **Time**: O(V × E)

### 4. Floyd-Warshall (All-pairs shortest path)
- DP: `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])` for all k
- **Time**: O(V³)

### 5. Prim's MST
- Start from any node, greedily add minimum weight edge to MST
- Use priority queue
- **Time**: O((V + E) log V)

### 6. Kruskal's MST
- Sort all edges by weight, add if doesn't form cycle (Union-Find)
- **Time**: O(E log E)
