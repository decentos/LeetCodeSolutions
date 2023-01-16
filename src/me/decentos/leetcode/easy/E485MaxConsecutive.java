package me.decentos.leetcode.easy;

public class E485MaxConsecutive {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSeq = 0, currSeq = 0;
        for (int i : nums) {
            if (i == 1) {
                currSeq++;
            } else {
                maxSeq = Math.max(maxSeq, currSeq);
                currSeq = 0;
            }
        }
        return Math.max(maxSeq, currSeq);
    }
}
