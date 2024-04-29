package graph.topologicalsort;

import java.util.*;

public class M207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outDegree = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            outDegree.computeIfAbsent(prerequisite[1], val -> new ArrayList<>()).add(prerequisite[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visitedCourses = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visitedCourses++;

            if (outDegree.containsKey(curr)) {
                List<Integer> neighbors = outDegree.get(curr);
                for (int neighbor : neighbors) {
                    inDegree[neighbor]--;

                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return visitedCourses == numCourses;
    }
}
