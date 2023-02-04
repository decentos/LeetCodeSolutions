import java.util.Arrays;

public class TipicoTest {
    public static void main(String[] args) {
        solution(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4});
    }

    public static String solution(int N) {
        char[] s = new char[N];
        Arrays.fill(s, 'a');
        if (N % 2 == 0) {
            s[0] = 'b';
        }
        return String.valueOf(s);
    }

    public static int solution(int[] A, int[] B) {
        int count = 0;
        long prefixA = 0, prefixB = 0, sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            prefixA += A[i];
            prefixB += B[i];
        }

        for (int i = 0; i < A.length - 1; i++) {
            sumA += A[i];
            sumB += B[i];
            long remainsA = prefixA - sumA;
            long remainsB = prefixB - sumB;
            if (remainsA == remainsB && sumA == remainsA && sumB == remainsB) {
                count++;
            }
        }
        return count;
    }
}
