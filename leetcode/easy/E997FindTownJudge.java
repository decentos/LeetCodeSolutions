package easy;

public class E997FindTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];

        for (int[] person : trust) {
            count[person[0]]--;
            count[person[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
