package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M735AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if ( Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }

        int[] afterCollisions = new int[stack.size()];
        for (int i = afterCollisions.length - 1; i >= 0; i--) {
            afterCollisions[i] = stack.pop();
        }
        return afterCollisions;
    }
}
