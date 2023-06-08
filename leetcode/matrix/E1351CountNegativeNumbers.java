package matrix;

public class E1351CountNegativeNumbers {

    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int rowPointer = m - 1, colPointer = 0;
        int count = 0;

        while (rowPointer >= 0 && colPointer < n) {
            if (grid[rowPointer][colPointer] < 0) {
                count = count + n - colPointer;
                rowPointer--;
            } else {
                colPointer++;
            }
        }
        return count;
    }
}
