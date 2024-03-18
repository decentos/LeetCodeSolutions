package greedy;

import java.util.ArrayList;
import java.util.List;

public class M763PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int max = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int last = lastIndex[s.charAt(i) - 'a'];
            max = Math.max(max, last);

            if (max == i) {
                partitions.add(max - prev + 1);
                prev = i + 1;
            }
        }
        return partitions;
    }
}
