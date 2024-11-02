package uber;

import java.util.Random;

public class M384ShuffleArray {
    private final int[] original;
    private final Random random;

    public M384ShuffleArray(int[] nums) {
        original = nums;
        random = new Random();
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int[] shuffle = original.clone();
        for (int i = 1; i < shuffle.length; i++) {
            swap(shuffle, i, random.nextInt(i + 1));
        }
        return shuffle;
    }

    private void swap(int[] shuffle, int index, int nextRandom) {
        int temp = shuffle[index];
        shuffle[index] = shuffle[nextRandom];
        shuffle[nextRandom] = temp;
    }
}