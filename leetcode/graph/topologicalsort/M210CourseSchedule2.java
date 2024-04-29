package graph.topologicalsort;

import java.util.*;

public class M210CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int insertIndex = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outDegree = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            outDegree.computeIfAbsent(prerequisite[1], val -> new ArrayList<>()).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[insertIndex++] = curr;

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
        return insertIndex == numCourses ? order : new int[0];
    }
}
