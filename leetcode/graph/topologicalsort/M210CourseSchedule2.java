package graph.topologicalsort;

import java.util.*;

public class M210CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outDegree = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int finishedCourses = 0;

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
            order[finishedCourses++] = curr;

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
        return finishedCourses == numCourses ? order : new int[0];
    }
}
