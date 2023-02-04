package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E599MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer index1 = map.get(list2[i]);
            if (index1 == null) continue;
            int currSum = index1 + i;
            if (currSum < minSum) {
                result.clear();
                minSum = currSum;
                result.add(list2[i]);
            } else if (currSum == minSum) {
                result.add(list2[i]);
            }
        }
        return result.toArray(String[]::new);
    }
}
