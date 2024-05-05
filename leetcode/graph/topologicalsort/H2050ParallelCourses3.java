package graph.topologicalsort;

import java.util.*;

public class H2050ParallelCourses3 {

    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] months = new int[n + 1];
        int[] inDegree = new int[n + 1];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] relation : relations) {
            int prevCourse = relation[0];
            int nextCourse = relation[1];
            inDegree[nextCourse]++;
            adj.computeIfAbsent(prevCourse, val -> new ArrayList<>()).add(nextCourse);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            months[currCourse] += time[currCourse - 1];

            if (adj.containsKey(currCourse)) {
                List<Integer> nextCourses = adj.get(currCourse);
                for (int nextCourse : nextCourses) {
                    months[nextCourse] = Math.max(months[nextCourse], months[currCourse]);

                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        int maxMonths = 0;
        for (int month : months) {
            maxMonths = Math.max(maxMonths, month);
        }
        return maxMonths;
    }
}
