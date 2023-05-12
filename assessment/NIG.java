import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NIG {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println(solution(new int[0]));
        System.out.println(solution(null));
        System.out.println(solution(1, 1_000_000_000));
        System.out.println(solutionRef(new int[]{4, 6, 2, 2, 6, 6, 1}));
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) return 0;

        int n = A.length, max = 0;
        Set<Integer> seen = new HashSet<>();

        for (int head = 0; head < n; head++) {
            int curr = 1;
            int tail = A[head];

            if (head != tail && (head == 0 || !seen.contains(head))) {
                seen.add(head);
                seen.add(tail);

                while (head != tail) {
                    tail = A[tail];
                    seen.add(tail);
                    curr++;
                }
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    public static int solution(int A, int B) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (i % 2 != 0) continue;

            int x = (int) Math.sqrt(i);
            if (x * (x + 1) == i) count++;
        }
        return count;
    }

    public static int solutionRef(int[] A) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int curr = A[i];
            if (map.containsKey(curr)) {
                max = Math.max(max, i - map.get(curr));
            } else {
                map.put(curr, i);
            }
        }
        return max;
    }
}
