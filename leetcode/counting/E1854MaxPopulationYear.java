package counting;

public class E1854MaxPopulationYear {

    public int maximumPopulation(int[][] logs) {
        int n = 2051;
        int[] population = new int[n];

        for (int[] log : logs) {
            population[log[0]]++;
            population[log[1]]--;
        }

        int max = Integer.MIN_VALUE, year = Integer.MAX_VALUE;
        int curr = 0;
        for (int i = 1950; i < n; i++) {
            curr += population[i];
            if (curr > max) {
                max = curr;
                year = i;
            }
        }
        return year;
    }
}
