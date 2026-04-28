import java.util.*;

/**
 * Day 24 — Advanced Graph Algorithms
 */
public class GraphAdvanced {

    // 1. Dijkstra's Algorithm
    public static int[] dijkstra(int V, List<List<int[]>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > dist[u]) continue;
            for (int[] edge : adj.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    // 2. Bellman-Ford
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }
        // Check negative cycle
        for (int[] edge : edges) {
            if (dist[edge[0]] != Integer.MAX_VALUE && dist[edge[0]] + edge[2] < dist[edge[1]])
                System.out.println("Negative cycle detected!");
        }
        return dist;
    }

    // 3. Floyd-Warshall
    public static int[][] floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) System.arraycopy(graph[i], 0, dist[i], 0, V);
        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        return dist;
    }

    // 4. Prim's MST
    public static int primsMST(int V, List<List<int[]>> adj) {
        boolean[] inMST = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0}); // {node, weight}
        int totalWeight = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];
            if (inMST[u]) continue;
            inMST[u] = true;
            totalWeight += w;
            for (int[] edge : adj.get(u))
                if (!inMST[edge[0]]) pq.add(new int[]{edge[0], edge[1]});
        }
        return totalWeight;
    }

    // 5. Kruskal's MST (Union-Find)
    static int[] parent, rank;
    public static int kruskalsMST(int V, int[][] edges) {
        parent = new int[V]; rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;
        Arrays.sort(edges, (a, b) -> a[2] - b[2]); // sort by weight
        int mstWeight = 0, edgeCount = 0;
        for (int[] edge : edges) {
            if (edgeCount == V - 1) break;
            int pu = find(edge[0]), pv = find(edge[1]);
            if (pu != pv) {
                union(pu, pv);
                mstWeight += edge[2];
                edgeCount++;
            }
        }
        return mstWeight;
    }
    private static int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
    private static void union(int a, int b) {
        if (rank[a] < rank[b]) { int t = a; a = b; b = t; }
        parent[b] = a;
        if (rank[a] == rank[b]) rank[a]++;
    }

    // 6. Kosaraju's SCC
    public static int countSCC(int V, List<List<Integer>> adj) {
        // Step 1: Fill stack by finish time
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) if (!visited[i]) dfs1(i, adj, visited, stack);
        // Step 2: Transpose graph
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) transpose.add(new ArrayList<>());
        for (int u = 0; u < V; u++) for (int v : adj.get(u)) transpose.get(v).add(u);
        // Step 3: DFS on transposed graph
        Arrays.fill(visited, false);
        int count = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) { dfs2(node, transpose, visited); count++; }
        }
        return count;
    }
    private static void dfs1(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int n : adj.get(node)) if (!visited[n]) dfs1(n, adj, visited, stack);
        stack.push(node);
    }
    private static void dfs2(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int n : adj.get(node)) if (!visited[n]) dfs2(n, adj, visited);
    }

    public static void main(String[] args) {
        // Dijkstra
        int V = 5;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new int[]{1, 2}); adj.get(0).add(new int[]{3, 6});
        adj.get(1).add(new int[]{2, 3}); adj.get(1).add(new int[]{3, 8});
        adj.get(2).add(new int[]{4, 7}); adj.get(3).add(new int[]{4, 9});
        System.out.println("Dijkstra: " + Arrays.toString(dijkstra(V, adj, 0)));

        // Kruskal
        int[][] edges = {{0,1,2},{0,3,6},{1,2,3},{1,3,8},{2,4,7},{3,4,9}};
        System.out.println("Kruskal MST: " + kruskalsMST(5, edges));
    }
}
