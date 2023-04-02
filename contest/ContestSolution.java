import w337.M2596CheckKnightTour;
import w337.M2597BeautifulSubsets;
import w338.M2601PrimeSubtractionOperation;
import w338.M2602MinOperationsArraysEqual;
import w339.E2609FindBalancedSubstring;
import w339.M2610ConvertArrayInto2D;
import w339.M2611MiceAndCheese;

public class ContestSolution {
    public static void main(String[] args) {
        M2597BeautifulSubsets m6352 = new M2597BeautifulSubsets();
        m6352.beautifulSubsets(new int[]{2,4,6}, 2);
        M2596CheckKnightTour m6322 = new M2596CheckKnightTour();
        m6322.checkValidGrid(new int[][]{{0,3,6}, {5,8,1}, {2,7,4}});
        M2602MinOperationsArraysEqual m2602 = new M2602MinOperationsArraysEqual();
        m2602.minOperations(new int[]{1,2,3}, new int[]{-3, 3});
        M2601PrimeSubtractionOperation m2601 = new M2601PrimeSubtractionOperation();
        m2601.primeSubOperation(new int[]{4,9,6,10});
        E2609FindBalancedSubstring e2609 = new E2609FindBalancedSubstring();
        e2609.findTheLongestBalancedSubstring("001011");
        M2610ConvertArrayInto2D m2610 = new M2610ConvertArrayInto2D();
        m2610.findMatrix(new int[]{1,3,4,1,2,3,1});
        M2611MiceAndCheese m2611 = new M2611MiceAndCheese();
        m2611.miceAndCheese(new int[]{1,1,3,4}, new int[]{4,4,1,1}, 2);
    }
}
