public class SonarSource {
    public static void main(String[] args) {
        new SonarSource().solution(new int[]{1, 3, -3});
    }

    public int solution(int A, int B) {
        int multiply = A * B;
        return Integer.bitCount(multiply);
    }

    public int solution(int[] A) {
        int min = A[0], minDiff = 0;
        int max = A[0], maxDiff = 0;

        for (int i = 1; i < A.length; i++) {
            minDiff = Math.max(minDiff, Math.abs(A[i] - min));
            min = Math.min(min, A[i]);

            maxDiff = Math.max(maxDiff, Math.abs(A[i] - max));
            max = Math.max(max, A[i]);
        }
        return Math.max(minDiff, maxDiff);
    }
}
