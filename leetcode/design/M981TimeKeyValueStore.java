package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class M981TimeKeyValueStore {
    private final Map<String, TreeMap<Integer, String>> map;

    public M981TimeKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        Map<Integer, String> values = map.get(key);
        values.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        TreeMap<Integer, String> values = map.get(key);
        Map.Entry<Integer, String> floorEntry = values.floorEntry(timestamp);
        return floorEntry == null ? "" : floorEntry.getValue();
    }
}
