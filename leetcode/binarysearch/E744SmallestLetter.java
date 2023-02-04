package binarysearch;

public class E744SmallestLetter {

    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        char next = '0';

        while (low <= high) {
            int mid = (low + high) / 2;
            if (letters[mid] == target && mid + 1 < letters.length) {
                while (mid + 1 < letters.length && letters[mid] == letters[mid + 1]) mid++;
                return mid == letters.length - 1 ? letters[0] : letters[mid + 1];
            } else if (letters[mid] > target) {
                high = mid - 1;
                next = letters[mid];
            } else {
                low = mid + 1;
            }
        }
        return next == '0' ? letters[0] : next;
    }
}
