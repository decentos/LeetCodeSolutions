package graph;

import java.util.*;

public class M1311WatchedVideosFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Deque<Integer> friendsOnLevel = new ArrayDeque<>();
        friendsOnLevel.offer(id);
        boolean[] visited = new boolean[friends.length];
        visited[id] = true;

        while (!friendsOnLevel.isEmpty() && level > 0) {
            int size = friendsOnLevel.size();
            for (int i = 0; i < size; i++) {
                int curr = friendsOnLevel.poll();
                for (int friend : friends[curr]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        friendsOnLevel.offer(friend);
                    }
                }
            }
            level--;
        }

        Map<String, Integer> freq = new HashMap<>();
        while (!friendsOnLevel.isEmpty()) {
            int friend = friendsOnLevel.poll();
            List<String> videos = watchedVideos.get(friend);
            for (String video : videos) {
                freq.merge(video, 1, Integer::sum);
            }
        }

        List<String> videos = new ArrayList<>(freq.keySet());
        videos.sort((v1, v2) -> {
            int freq1 = freq.get(v1);
            int freq2 = freq.get(v2);
            if (freq1 == freq2) {
                return v1.compareTo(v2);
            } else {
                return freq1 - freq2;
            }
        });
        return videos;
    }
}
