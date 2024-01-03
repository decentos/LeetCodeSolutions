package matrix;

public class M2125NumberLaserBeams {

    public int numberOfBeams(String[] bank) {
        int prev = 0, ans = 0;

        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            if (count > 0) {
                ans += prev * count;
                prev = count;
            }
        }
        return ans;
    }
}
