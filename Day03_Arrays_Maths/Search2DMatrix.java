/**
 * Search in a 2D Matrix
 * 
 * Matrix Properties:
 *   - Each row is sorted in ascending order
 *   - First element of each row > last element of previous row
 * 
 * Approach: Binary Search treating matrix as virtual 1D array
 *   - row = mid / numCols
 *   - col = mid % numCols
 * 
 * Time Complexity: O(log(m × n))
 * Space Complexity: O(1)
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;
            int midVal = matrix[row][col];

            if (midVal == target) return true;
            else if (midVal < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        System.out.println("Search 3: " + searchMatrix(matrix, 3));   // true
        System.out.println("Search 13: " + searchMatrix(matrix, 13)); // false
    }
}
