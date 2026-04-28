import java.util.*;

/**
 * Day 23 — Graph Problems
 */
public class GraphProblems {

    // 1. DFS
    public static List<Integer> dfs(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsHelper(0, adj, visited, result);
        return result;
    }
    private static void dfsHelper(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int neighbor : adj.get(node))
            if (!visited[neighbor]) dfsHelper(neighbor, adj, visited, result);
    }

    // 2. BFS
    public static List<Integer> bfs(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : adj.get(node))
                if (!visited[neighbor]) { visited[neighbor] = true; queue.add(neighbor); }
        }
        return result;
    }

    // 3. Detect Cycle — Undirected (DFS)
    public static boolean hasCycleUndirected(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i] && dfsCycleUndirected(i, -1, adj, visited)) return true;
        return false;
    }
    private static boolean dfsCycleUndirected(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) { if (dfsCycleUndirected(neighbor, node, adj, visited)) return true; }
            else if (neighbor != parent) return true;
        }
        return false;
    }

    // 4. Detect Cycle — Directed (DFS with 3 colors)
    public static boolean hasCycleDirected(int V, List<List<Integer>> adj) {
        int[] color = new int[V]; // 0=white, 1=gray, 2=black
        for (int i = 0; i < V; i++)
            if (color[i] == 0 && dfsCycleDirected(i, adj, color)) return true;
        return false;
    }
    private static boolean dfsCycleDirected(int node, List<List<Integer>> adj, int[] color) {
        color[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == 1) return true;
            if (color[neighbor] == 0 && dfsCycleDirected(neighbor, adj, color)) return true;
        }
        color[node] = 2;
        return false;
    }

    // 5. Topological Sort (Kahn's BFS)
    public static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) for (int n : adj.get(i)) indegree[n]++;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indegree[i] == 0) queue.add(i);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int n : adj.get(node)) if (--indegree[n] == 0) queue.add(n);
        }
        return result;
    }

    // 6. Number of Islands
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') { dfsIsland(grid, i, j); count++; }
        return count;
    }
    private static void dfsIsland(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfsIsland(grid, r+1, c); dfsIsland(grid, r-1, c);
        dfsIsland(grid, r, c+1); dfsIsland(grid, r, c-1);
    }

    // 7. Bipartite Check (BFS)
    public static boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V]; Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] != -1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i); color[i] = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int nb : adj.get(node)) {
                    if (color[nb] == -1) { color[nb] = 1 - color[node]; q.add(nb); }
                    else if (color[nb] == color[node]) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Number of Islands
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("Islands: " + numIslands(grid)); // 3

        // Topo Sort
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(5).add(2); adj.get(5).add(0); adj.get(4).add(0); adj.get(4).add(1);
        adj.get(2).add(3); adj.get(3).add(1);
        System.out.println("Topo Sort: " + topoSort(V, adj));
    }
}
