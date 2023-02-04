package easy;

public class E1672RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int current = 0;
            for (int amount : account) {
                current += amount;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
