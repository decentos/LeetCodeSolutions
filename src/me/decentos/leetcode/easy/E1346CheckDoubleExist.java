package me.decentos.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class E1346CheckDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) return true;
            set.add(i);
        }
        return false;
    }
}
