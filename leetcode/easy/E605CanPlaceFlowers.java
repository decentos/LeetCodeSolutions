package easy;

public class E605CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if (n == 0) break;
            if (flowerbed[i] == 1) continue;

            boolean emptyLeft = i == 0 || flowerbed[i - 1] == 0;
            boolean emptyRight = i== m - 1 || flowerbed[i + 1] == 0;

            if (emptyLeft && emptyRight) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
