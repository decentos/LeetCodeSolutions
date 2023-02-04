package easy;

import java.util.ArrayList;
import java.util.List;

public class E118PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j) + prev.get(j - 1));
            }
            curr.add(1);
            triangle.add(curr);
        }
        return triangle;
    }
}
