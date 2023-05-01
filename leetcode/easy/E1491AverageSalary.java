package easy;

public class E1491AverageSalary {

    public double average(int[] salary) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i : salary) {
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return (double) (sum - min - max) / (salary.length - 2);
    }
}
