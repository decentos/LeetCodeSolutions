import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bitvavo {

    public static long maxValue(int n, List<List<Integer>> rounds) {
        long[] diff = new long[n + 1];

        for (List<Integer> round : rounds) {
            int left = round.get(0) - 1;
            int right = round.get(1) - 1;
            int contribution = round.get(2);

            diff[left] += contribution;
            if (right + 1 < n) {
                diff[right + 1] -= contribution;
            }
        }

        long maxInvestment = 0;
        long currInvestment = 0;

        for (int i = 0; i < n; i++) {
            currInvestment += diff[i];
            maxInvestment = Math.max(maxInvestment, currInvestment);
        }
        return maxInvestment;
    }

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        List<Long> sentencesCount = new ArrayList<>();
        Map<String, Integer> anagrams = new HashMap<>();

        for (String word : wordSet) {
            char[] freq = new char[26];
            for (char letter : word.toCharArray()) {
                freq[letter - 'a']++;
            }
            String key = String.valueOf(freq);
            anagrams.merge(key, 1, Integer::sum);
        }

        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            long count = 1;

            for (String word : words) {
                char[] freq = new char[26];
                for (char letter : word.toCharArray()) {
                    freq[letter - 'a']++;
                }
                String key = String.valueOf(freq);
                if (anagrams.containsKey(key)) {
                    count *= anagrams.get(key);
                }
            }
            sentencesCount.add(count);
        }
        return sentencesCount;
    }

}


interface Bank {
    void assignLoans(int[] loans);
    void averageLoan();
    void maxLoan();
    void minLoan();
}

class PersonalLoanDept implements Bank {
    private final int[] loanAmounts;
    private final LoanCalculator loanCalculator;

    public PersonalLoanDept(int clients) {
        loanAmounts = new int[clients];
        loanCalculator = new LoanCalculator();
    }

    @Override
    public void assignLoans(int[] loans) {
        int length = Math.min(loans.length, loanAmounts.length);
        System.arraycopy(loans, 0, loanAmounts, 0, length);
        System.out.println("Loans for clients processed");
    }

    @Override
    public void averageLoan() {
        double average = loanCalculator.calculateAverageLoan(loanAmounts);
        System.out.printf("Average loan amount for clients is %.2f%n", average);
    }

    @Override
    public void maxLoan() {
        int maxLoan = loanCalculator.calculateMaxLoan(loanAmounts);
        System.out.println("Maximum loan amount amongst clients is " + maxLoan);
    }

    @Override
    public void minLoan() {
        int minLoan = loanCalculator.calculateMinLoan(loanAmounts);
        System.out.println("Minimum loan amount amongst clients is " + minLoan);
    }
}

class BusinessLoanDept implements Bank {
    private final int[] loanAmounts;
    private final LoanCalculator loanCalculator;

    public BusinessLoanDept(int businesses) {
        loanAmounts = new int[businesses];
        loanCalculator = new LoanCalculator();
    }

    @Override
    public void assignLoans(int[] loans) {
        int length = Math.min(loans.length, loanAmounts.length);
        System.arraycopy(loans, 0, loanAmounts, 0, length);
        System.out.println("Loans for businesses processed");
    }

    @Override
    public void averageLoan() {
        double average = loanCalculator.calculateAverageLoan(loanAmounts);
        System.out.printf("Average loan amount for businesses is %.2f%n", average);
    }

    @Override
    public void maxLoan() {
        int maxLoan = loanCalculator.calculateMaxLoan(loanAmounts);
        System.out.println("Maximum loan amongst businesses is " + maxLoan);
    }

    @Override
    public void minLoan() {
        int minLoan = loanCalculator.calculateMinLoan(loanAmounts);
        System.out.println("Minimum loan amongst businesses is " + minLoan);
    }
}

class LoanCalculator {

    public double calculateAverageLoan(int[] loanAmounts) {
        double sum = 0;
        for (int loan : loanAmounts) {
            sum += loan;
        }
        return sum / loanAmounts.length;
    }

    public int calculateMaxLoan(int[] loanAmounts) {
        int maxLoan = Integer.MIN_VALUE;
        for (int loan : loanAmounts) {
            maxLoan = Math.max(maxLoan, loan);
        }
        return maxLoan;
    }

    public int calculateMinLoan(int[] loanAmounts) {
        int minLoan = Integer.MAX_VALUE;
        for (int loan : loanAmounts) {
            minLoan = Math.min(minLoan, loan);
        }
        return minLoan;
    }
}