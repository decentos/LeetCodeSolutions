package w338;

public class E2600KItemsWithMaxSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) return k;
        if (k <= numOnes + numZeros) return numOnes;
        k -= numOnes + numZeros;
        return numOnes - k;
    }
}
