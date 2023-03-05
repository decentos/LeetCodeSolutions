package medium;

public class M779KSymbolGrammar {

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        if (k % 2 == 0) {
            return parent == 1 ? 0 : 1;
        } else {
            return parent;
        }
    }
}
