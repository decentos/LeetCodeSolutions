package design;

public class M348DesignTicTacToe {
    private final int n;
    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public M348DesignTicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int step = player == 1 ? 1 : -1;

        rows[row] += step;
        if (Math.abs(rows[row]) == n) return player;

        cols[col] += step;
        if (Math.abs(cols[col]) == n) return player;

        if (row == col) diagonal += step;
        if (Math.abs(diagonal) == n) return player;

        if (row + col == n - 1) antiDiagonal += step;
        if (Math.abs(antiDiagonal) == n) return player;

        return 0;
    }
}
