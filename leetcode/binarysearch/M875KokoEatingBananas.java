package binarysearch;

public class M875KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        if (n == h) {
            return max;
        }

        int left = 1, right = max;
        int min = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (long) Math.ceil((double) pile / mid);
            }

            if (hours <= h) {
                right = mid - 1;
                min = mid;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
