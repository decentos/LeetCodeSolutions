package codegoda23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SearchRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hotelsCount = sc.nextInt();
        int queriesCount = sc.nextInt();

        List<Hotel> hotels = new ArrayList<>();
        for (int i = 0; i < hotelsCount; i++) {
            int id = sc.nextInt();
            int keywords = sc.nextInt();
            Hotel hotel = new Hotel(id);
            for (int j = 0; j < keywords; j++) {
                String keyword = sc.next();
                int score = sc.nextInt();
                hotel.addKeyword(keyword, score);
            }
            hotels.add(hotel);
        }

        for (int i = 0; i < queriesCount; i++) {
            int length = sc.nextInt();
            String[] query = new String[length];
            for (int j = 0; j < length; j++) {
                query[j] = sc.next();
            }

            Queue<Hotel> relevantHotels = new PriorityQueue<>((h1, h2) -> {
                int r1 = h1.getRelevance(query);
                int r2 = h2.getRelevance(query);
                return r1 == r2 ? h1.getId() - h2.getId() : r2 - r1;
            });
            for (Hotel hotel : hotels) {
                int relevance = hotel.getRelevance(query);
                if (relevance > 0) relevantHotels.add(hotel);
            }

            if (relevantHotels.isEmpty()) {
                System.out.println("-1");
            } else {
                int count = Math.min(relevantHotels.size(), 10);
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    result.append(relevantHotels.poll().getId()).append(" ");
                }
                System.out.println(result.substring(0, result.length() - 1));
            }
        }
        sc.close();
    }

    private static class Hotel {
        private final int id;
        private final Map<String, Integer> keywords;

        public Hotel(int id) {
            this.id = id;
            this.keywords = new HashMap<>();
        }

        public void addKeyword(String keyword, int score) {
            this.keywords.put(keyword, score);
        }

        public int getRelevance(String[] query) {
            int relevance = 0;
            for (String word : query) {
                relevance += this.keywords.getOrDefault(word, 0);
            }
            return relevance;
        }

        public int getId() {
            return this.id;
        }
    }
}
