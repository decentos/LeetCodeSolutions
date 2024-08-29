package greedy;

public class E605CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (n == 0) {
                break;
            }
            if (flowerbed[i] == 1) {
                continue;
            }

            boolean isEmptyLeft = i == 0 || flowerbed[i - 1] == 0;
            boolean isEmptyRight = i == len - 1 || flowerbed[i + 1] == 0;

            if (isEmptyLeft && isEmptyRight) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
