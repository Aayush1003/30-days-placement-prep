import java.util.*;

/**
 * Day 10 — Backtracking Problems
 */
public class BacktrackingProblems {

    // 1. All Permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }
    private static void permuteHelper(int[] nums, int idx, List<List<Integer>> result) {
        if (idx == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) perm.add(n);
            result.add(perm);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permuteHelper(nums, idx + 1, result);
            swap(nums, idx, i);
        }
    }

    // 2. N-Queens
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        boolean[] col = new boolean[n], leftDiag = new boolean[2*n-1], rightDiag = new boolean[2*n-1];
        nQueens(board, 0, col, leftDiag, rightDiag, result, n);
        return result;
    }
    private static void nQueens(char[][] board, int row, boolean[] col, boolean[] ld, boolean[] rd, List<List<String>> result, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) solution.add(new String(r));
            result.add(solution);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (!col[c] && !ld[row - c + n - 1] && !rd[row + c]) {
                board[row][c] = 'Q';
                col[c] = ld[row - c + n - 1] = rd[row + c] = true;
                nQueens(board, row + 1, col, ld, rd, result, n);
                board[row][c] = '.';
                col[c] = ld[row - c + n - 1] = rd[row + c] = false;
            }
        }
    }

    // 3. Sudoku Solver
    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudoku(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }

    // 4. Rat in a Maze
    public static List<String> ratInMaze(int[][] maze, int n) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if (maze[0][0] == 1) {
            visited[0][0] = true;
            ratHelper(maze, 0, 0, n, "", visited, result);
        }
        return result;
    }
    private static void ratHelper(int[][] maze, int r, int c, int n, String path, boolean[][] visited, List<String> result) {
        if (r == n-1 && c == n-1) { result.add(path); return; }
        int[] dr = {1, 0, 0, -1}; int[] dc = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && maze[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                ratHelper(maze, nr, nc, n, path + dir[i], visited, result);
                visited[nr][nc] = false;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }

    public static void main(String[] args) {
        System.out.println("Permutations: " + permute(new int[]{1,2,3}));
        System.out.println("\nN-Queens (4): " + solveNQueens(4).size() + " solutions");
        
        int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        System.out.println("\nRat in Maze: " + ratInMaze(maze, 4));
    }
}
