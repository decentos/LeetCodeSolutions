package counting;

public class E1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int insertIndex = 0;
        int[] sorted = new int[n];
        int[] counter = new int[1001];

        for (int num : arr1) {
            counter[num]++;
        }

        for (int num : arr2) {
            int count = counter[num];
            for (int i = 0; i < count; i++) {
                sorted[insertIndex++] = num;
            }
            counter[num] = 0;
        }

        for (int num = 0; num < counter.length; num++) {
            int count = counter[num];
            for (int i = 0; i < count; i++) {
                sorted[insertIndex++] = num;
            }
        }
        return sorted;
    }
}
