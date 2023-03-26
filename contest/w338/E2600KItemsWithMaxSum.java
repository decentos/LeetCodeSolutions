package w338;

public class E2600KItemsWithMaxSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) return k;
        else if (k <= numOnes + numZeros) return numOnes;
        else {
            k -= numOnes + numZeros;
            return numOnes - k;
        }
    }
}
