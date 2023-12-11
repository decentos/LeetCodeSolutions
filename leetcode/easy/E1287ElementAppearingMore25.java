package easy;

public class E1287ElementAppearingMore25 {

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int quarter = n / 4;

        for (int i = 0; i < n - quarter; i++) {
            if (arr[i] == arr[i + quarter]) {
                return arr[i];
            }
        }
        return -1;
    }
}
