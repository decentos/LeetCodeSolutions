package me.decentos.leetcode.easy;

public class E414ThirdMaxNumber {

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int i : nums) {
            if (i == first || i == second || i == third) continue;
            if (i > first) {
                third = second;
                second = first;
                first = i;
            } else if (i > second) {
                third = second;
                second = i;
            } else if (i > third) {
                third = i;
            }
        }
        if (third == Long.MIN_VALUE) return (int) first;
        else return (int) third;
    }
}
