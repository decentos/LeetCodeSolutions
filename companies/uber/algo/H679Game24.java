package uber.algo;

import java.util.ArrayList;
import java.util.List;

public class H679Game24 {

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return isResultReached(list);
    }

    private boolean isResultReached(List<Double> cards) {
        if (cards.size() == 1) {
            return Math.abs(cards.getFirst() - 24) <= 0.1;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {

                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < cards.size(); k++) {
                    if (k != i && k != j) {
                        newList.add(cards.get(k));
                    }
                }

                for (double result : getAllPossibleResults(cards.get(i), cards.get(j))) {
                    newList.add(result);
                    if (isResultReached(newList)) {
                        return true;
                    }
                    newList.removeLast();
                }
            }
        }
        return false;
    }

    private List<Double> getAllPossibleResults(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (a != 0) {
            results.add(b / a);
        }
        if (b != 0) {
            results.add(a / b);
        }
        return results;
    }
}
