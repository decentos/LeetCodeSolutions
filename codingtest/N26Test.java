import java.util.Arrays;

public class N26Test {

    public boolean solution1(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }

    public int solution2(int[] A) {
        int l = 0, r = A.length - 1, sum = 0;
        Arrays.sort(A);
        while (l < r) {
            sum += A[r] - A[l];
            l++;
            r--;
        }
        return sum;
    }

    public int solution3(int[] A) {
        int count = 0, prev = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            int curr = A[i], next = A[i + 1];
            if ((prev < curr && curr > next) || (prev > curr && curr < next)) {
                count++;
                prev = curr;
            }
        }

        if (count == 0) {
            if (A[0] == A[A.length - 1]) return 1;
            else return 2;
        }
        return count + 2;
    }

}
