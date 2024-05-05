package graph.topologicalsort;

import java.util.*;

public class M1136ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
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

        int takenCourses = 0;
        int semesters = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            semesters++;

            for (int i = 0; i < size; i++) {
                int currCourse = queue.poll();
                takenCourses++;

                if (adj.containsKey(currCourse)) {
                    List<Integer> nextCourses = adj.get(currCourse);
                    for (int nextCourse : nextCourses) {
                        inDegree[nextCourse]--;

                        if (inDegree[nextCourse] == 0) {
                            queue.offer(nextCourse);
                        }
                    }
                }
            }
        }
        return takenCourses == n ? semesters : -1;
    }
}
