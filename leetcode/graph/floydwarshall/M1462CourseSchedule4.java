package graph.floydwarshall;

import java.util.*;

public class M1462CourseSchedule4 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> answer = new ArrayList<>();
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            adj.computeIfAbsent(prerequisite[0], val -> new ArrayList<>()).add(prerequisite[1]);
        }

        for (int node = 0; node < numCourses; node++) {
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(node);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                if (adj.containsKey(curr)) {
                    List<Integer> neighbors = adj.get(curr);
                    for (int neighbor : neighbors) {
                        if (!isPrerequisite[node][neighbor]) {
                            isPrerequisite[node][neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        for (int[] query : queries) {
            answer.add(isPrerequisite[query[0]][query[1]]);
        }
        return answer;
    }

    // Floyd Warshall Algorithm
    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        List<Boolean> answer = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            isPrerequisite[prerequisite[0]][prerequisite[1]] = true;
        }

        for (int intermediate = 0; intermediate < numCourses; intermediate++) {
            for (int source = 0; source < numCourses; source++) {
                for (int target = 0; target < numCourses; target++) {
                    isPrerequisite[source][target] = isPrerequisite[source][target] || (isPrerequisite[source][intermediate] && isPrerequisite[intermediate][target]);
                }
            }
        }

        for (int[] query : queries) {
            answer.add(isPrerequisite[query[0]][query[1]]);
        }
        return answer;
    }
}
