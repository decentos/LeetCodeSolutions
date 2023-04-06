package stack;

import java.util.Stack;

public class M739DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int currTemp = temperatures[currDay];
            while (!stack.empty() && currTemp > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        return answer;
    }
}
