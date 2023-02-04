package easy;

public class E1089DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for (int isZero = 0; isZero < arr.length; isZero++) {
            if (arr[isZero] == 0) {
                System.arraycopy(arr, isZero, arr, isZero + 1, arr.length - isZero - 1);
                isZero++;
            }
        }
    }

    public void duplicateZeros2(int[] arr) {
        int possibleDups = 0;
        int index = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= index - possibleDups; left++) {
            // Count the zeros
            if (arr[left] == 0) {
                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == index - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[index] = 0;
                    index -= 1;
                    break;
                }
                possibleDups++;
            }
        }
        // Start backwards from the last element which would be part of new array.
        int last = index - possibleDups;
        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
