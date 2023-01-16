package me.decentos.leetcode.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E170TwoSum3 {

    class TwoSum {
        private final List<Integer> numbers;
        private boolean isSorted;

        public TwoSum() {
            numbers = new ArrayList<>();
            isSorted = false;
        }

        public void add(int number) {
            numbers.add(number);
            isSorted = false;
        }

        public boolean find(int value) {
            if (!isSorted) {
                Collections.sort(numbers);
                isSorted = true;
            }
            int l = 0, r = numbers.size() - 1;
            while (l < r) {
                int sum = numbers.get(l) + numbers.get(r);
                if (sum == value) return true;
                else if (sum > value) r--;
                else l++;
            }
            return false;
        }
    }
}
