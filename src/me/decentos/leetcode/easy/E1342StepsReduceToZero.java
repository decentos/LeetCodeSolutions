package me.decentos.leetcode.easy;

public class E1342StepsReduceToZero {

    public int numberOfSteps(int num) {
        int counter = 0;
        while (num != 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            counter++;
        }
        return counter;
    }
}
