package graph;

import java.util.*;

public class H2092FindPeopleWithSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] meeting : meetings) {
            adj.computeIfAbsent(meeting[0], val -> new ArrayList<>()).add(new int[]{meeting[1], meeting[2]});
            adj.computeIfAbsent(meeting[1], val -> new ArrayList<>()).add(new int[]{meeting[0], meeting[2]});
        }

        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{firstPerson, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currPerson = curr[0];
            int currTime = curr[1];

            if (adj.containsKey(currPerson)) {
                for (int[] meeting : adj.get(currPerson)) {
                    int meetingPerson = meeting[0];
                    int meetingTime = meeting[1];

                    if (meetingTime >= currTime && meetingTime < earliest[meetingPerson]) {
                        earliest[meetingPerson] = meetingTime;
                        queue.offer(new int[]{meetingPerson, meetingTime});
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}
