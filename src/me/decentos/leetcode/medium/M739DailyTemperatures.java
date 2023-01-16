package me.decentos.leetcode.medium;

import java.util.Stack;

public class M739DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int currTemp = temperatures[currDay];
            while (!stack.empty() && temperatures[stack.peek()] < currTemp) {
                int prevDay = stack.pop();
                res[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        return res;
    }
}
