package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M739DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.poll();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        return answer;
    }
}
