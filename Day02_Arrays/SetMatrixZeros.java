/**
 * Set Matrix Zeros
 * 
 * Problem: Given an m×n matrix, if an element is 0, set its entire row and column to 0.
 * 
 * Optimal Approach (O(1) space):
 *   - Use first row and first column as markers
 *   - Variable col0 tracks whether first column should be zeroed
 * 
 * Time Complexity: O(m × n)
 * Space Complexity: O(1)
 */
import java.util.Arrays;

public class SetMatrixZeros {

    public static void setZeros(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean col0 = false;

        // Step 1: Mark which rows and columns need to be zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row
                    matrix[0][j] = 0; // Mark column
                }
            }
        }

        // Step 2: Fill zeros (traverse from bottom-right to avoid overwriting markers)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        System.out.println("Before:");
        printMatrix(matrix);

        setZeros(matrix);

        System.out.println("After:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println("  " + Arrays.toString(row));
        }
    }
}
