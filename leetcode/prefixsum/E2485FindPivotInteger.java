package prefixsum;

public class E2485FindPivotInteger {

    public int pivotInteger(int n) {
        int leftSum = n * (n + 1) / 2, rightSum = 0;

        for (int i = n; i > 0; i--) {
            rightSum += i;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum -= i;
        }
        return -1;
    }

    public int pivotInteger2(int n) {
        int sum = n * (n + 1) / 2;
        int pivot = (int) Math.sqrt(sum);
        return pivot * pivot == sum ? pivot : -1;
    }
}
