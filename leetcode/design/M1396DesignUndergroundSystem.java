package design;

import java.util.HashMap;
import java.util.Map;

public class M1396DesignUndergroundSystem {
    private final Map<Integer, TravelInfo> checkInDate;
    private final Map<String, TimeInfo> timeData;

    public M1396DesignUndergroundSystem() {
        checkInDate = new HashMap<>();
        timeData = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInDate.put(id, new TravelInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        TravelInfo travel = checkInDate.get(id);
        String direction = travel.stationName + "->" + stationName;
        TimeInfo time = timeData.getOrDefault(direction, new TimeInfo(0, 0));
        time.travelCount++;
        time.totalTime += t - travel.time;
        timeData.put(direction, time);
    }

    public double getAverageTime(String startStation, String endStation) {
        TimeInfo time = timeData.get(startStation + "-" + endStation);
        return time == null ? 0 : time.totalTime / time.travelCount;
    }

    private static class TravelInfo {
        String stationName;
        int time;

        public TravelInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class TimeInfo {
        double travelCount;
        double totalTime;

        public TimeInfo(double travelCount, double totalTime) {
            this.travelCount = travelCount;
            this.totalTime = totalTime;
        }
    }
}
