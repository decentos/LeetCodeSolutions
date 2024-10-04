package bit;

public class M1318MinFlips {

    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (1 << i & a) > 0 ? 1 : 0;
            int bitB = (1 << i & b) > 0 ? 1 : 0;
            int bitC = (1 << i & c) > 0 ? 1 : 0;

            if (bitC == 0) {
                flips += bitA + bitB;
            } else if (bitA == 0 && bitB == 0) {
                flips++;
            }
        }
        return flips;
    }
}
