package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void bucketSort(int[] arr, int count) {
        List<List<Integer>> buckets = new ArrayList<>(count);
        for (int i = 0; i < count; i++) buckets.add(new ArrayList<>());

        int max = Integer.MIN_VALUE;
        for (int i : arr) max = Math.max(max, i);

        for (int i : arr) {
            int bucketNumber = i * count / max;
            bucketNumber = bucketNumber == count ? bucketNumber - 1 : bucketNumber;
            List<Integer> bucket = buckets.get(bucketNumber);
            bucket.add(i);
        }

        for (List<Integer> bucket : buckets) Collections.sort(bucket);
        List<Integer> sorted = buckets.stream().flatMap(List::stream).toList();
        Arrays.setAll(arr, sorted::get);
    }
}
