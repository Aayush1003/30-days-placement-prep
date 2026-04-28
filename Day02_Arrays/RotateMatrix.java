/**
 * Rotate Matrix 90 Degrees Clockwise
 * 
 * Problem: Rotate an N×N matrix by 90 degrees clockwise in-place.
 * 
 * Approach: Transpose the matrix + Reverse each row
 *   - Transpose: swap matrix[i][j] with matrix[j][i]
 *   - Reverse: reverse each row
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
import java.util.Arrays;

public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Before rotation:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("After 90° clockwise rotation:");
        printMatrix(matrix);
        // Expected: [[7,4,1],[8,5,2],[9,6,3]]
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println("  " + Arrays.toString(row));
        }
    }
}
