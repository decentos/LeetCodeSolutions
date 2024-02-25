package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class H2402MeetingRooms3 {

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int[] count = new int[n];
        Queue<Room> usedRooms = new PriorityQueue<>();
        Queue<Integer> freeRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        for (int[] meeting : meetings) {
            while (!usedRooms.isEmpty() && meeting[0] >= usedRooms.peek().bookedTo) {
                freeRooms.offer(usedRooms.poll().roomId);
            }

            if (!freeRooms.isEmpty()) {
                int roomId = freeRooms.poll();
                usedRooms.offer(new Room(roomId, meeting[1]));
                count[roomId]++;
            } else {
                Room room = usedRooms.poll();
                count[room.roomId]++;
                usedRooms.offer(new Room(room.roomId, room.bookedTo + meeting[1] - meeting[0]));
            }
        }

        int maxCount = 0, minId = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                minId = i;
            }
        }
        return minId;
    }

    private static class Room implements Comparable<Room> {
        int roomId;
        long bookedTo;

        public Room(int roomId, long bookedTo) {
            this.roomId = roomId;
            this.bookedTo = bookedTo;
        }

        @Override
        public int compareTo(Room room) {
            int bookedTo = Long.compare(this.bookedTo, room.bookedTo);
            return bookedTo == 0 ? Integer.compare(this.roomId, room.roomId) : bookedTo;
        }
    }
}
