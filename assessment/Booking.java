import java.util.*;

public class Booking {

    public static List<String> funWithAnagrams(List<String> text) {
        Set<String> anagrams = new HashSet<>();
        List<String> unique = new ArrayList<>();

        for (String word : text) {
            char[] freq = new char[26];
            for (char letter : word.toCharArray()) {
                freq[letter - 'a']++;
            }
            String key = String.valueOf(freq);
            if (!anagrams.contains(key)) {
                anagrams.add(key);
                unique.add(word);
            }
        }

        Collections.sort(unique);
        return unique;
    }

    public static int findLargestSquareSize(List<List<Integer>> samples) {
        int n = samples.size();
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][n + 1];
        int max = 0;

        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (samples.get(row).get(col) == 1) {
                    int down = dp[row + 1][col];
                    int right = dp[row][col + 1];
                    int diagonal = dp[row + 1][col + 1];
                    dp[row][col] = Math.min(down, Math.min(right, diagonal)) + 1;
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        return max;
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positiveKeywords.toLowerCase().split("\\s")));
        Set<String> negative = new HashSet<>(Arrays.asList(negativeKeywords.toLowerCase().split("\\s")));
        int n = hotelIds.size();
        Map<Integer, Integer> rating = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int points = calculate(positive, negative, reviews.get(i));
            rating.merge(hotelIds.get(i), points, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> hotels = new ArrayList<>(rating.entrySet());
        hotels.sort((a, b) -> Objects.equals(a.getValue(), b.getValue()) ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        List<Integer> topK = new ArrayList<>();
        for (int i = 0; i < k && i < hotels.size(); i++) {
            topK.add(hotels.get(i).getKey());
        }
        return topK;
    }

    private static int calculate(Set<String> positive, Set<String> negative, String review) {
        int points = 0;
        String[] hotelReview = review.toLowerCase().split("[^a-zA-Z]+");
        for (String word : hotelReview) {
            if (positive.contains(word)) {
                points += 3;
            } else if (negative.contains(word)) {
                points -= 1;
            }
        }
        return points;
    }
}
