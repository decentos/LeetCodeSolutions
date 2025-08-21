import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Booking2 {

    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        int n = s.length();
        int netShift = (rightShifts - leftShifts) % n;

        if (netShift == 0) {
            return s;
        } else if (netShift < 0) {
            netShift += n;
        }

        return s.substring(n - netShift) + s.substring(0, n - netShift);
    }

    public static int minSum(List<Integer> num, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;

        for (int curr : num) {
            maxHeap.offer(curr);
            sum += curr;
        }

        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll();
            int reduced = (largest + 1) / 2;
            sum = sum - (largest - reduced);
            maxHeap.offer(reduced);
        }
        return sum;
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
        hotels.sort((a, b) -> Objects.equals(a.getValue(), b.getValue())
                ? Integer.compare(a.getKey(), b.getKey())
                : Integer.compare(b.getValue(), a.getValue()));

        return hotels.subList(0, Math.min(k, hotels.size()))
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
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
