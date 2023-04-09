package w340;

public class E2614PrimeDiagonal {

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int diagonal = nums[i][i];
            int antiDiagonal = nums[i][n - i - 1];

            if (isPrime(diagonal)) max = Math.max(max, diagonal);
            if (isPrime(antiDiagonal)) max = Math.max(max, antiDiagonal);
        }
        return max;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
