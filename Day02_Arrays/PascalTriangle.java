/**
 * Pascal's Triangle
 * 
 * Problem: Generate Pascal's Triangle up to numRows.
 * 
 * Key Property: triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]
 * Each row starts and ends with 1.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(n²) for the result
 */
import java.util.*;

public class PascalTriangle {

    // Generate entire Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    // Get nth row of Pascal's Triangle (0-indexed)
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            val = val * (rowIndex - i + 1) / i;
            row.add((int) val);
        }
        return row;
    }

    // Find element at position (r, c) — using nCr formula
    public static int getElement(int row, int col) {
        // Element = C(row-1, col-1)
        return nCr(row - 1, col - 1);
    }

    private static int nCr(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int numRows = 6;
        List<List<Integer>> triangle = generate(numRows);

        System.out.println("Pascal's Triangle (" + numRows + " rows):");
        for (int i = 0; i < triangle.size(); i++) {
            // Print spaces for alignment
            for (int s = 0; s < numRows - i - 1; s++) System.out.print(" ");
            System.out.println(triangle.get(i));
        }

        System.out.println("\nRow 5 (0-indexed): " + getRow(5));
        System.out.println("Element at (4, 3): " + getElement(4, 3));
    }
}
