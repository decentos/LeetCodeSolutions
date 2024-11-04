package string;

import java.util.ArrayList;
import java.util.List;

public class H2468SplitMessageLimit {

    public String[] splitMessage(String message, int limit) {
        int[] segments = {
                (limit - 5) * 9,
                (limit - 6) * 9 + (limit - 7) * 90,
                (limit - 7) * 9 + (limit - 8) * 90 + (limit - 9) * 900,
                (limit - 8) * 9+ (limit - 9) * 90 + (limit - 10) * 900 + (limit - 11) * 9000,
        };

        int n = message.length(), segment = 0;
        while (segment < segments.length && segments[segment] < n) {
            segment++;
        }

        if (segment == segments.length) {
            return new String[0];
        }

        List<String> split = new ArrayList<>();
        int partIndex = 1, messageIndex = 0;

        for (int i = 0; i <= segment; i++) {
            int length = limit - 5 - segment - i;
            int segmentLimit = (int) (9 * Math.pow(10, i));

            for (int j = 0; j < segmentLimit && messageIndex < n; j++) {
                String part = message.substring(messageIndex, Math.min(n, messageIndex + length));
                String metadata = String.format("<%d/", partIndex);
                split.add(part + metadata);
                messageIndex += length;
                partIndex++;
            }
        }

        int totalParts = partIndex - 1;
        String[] splitArray = new String[split.size()];
        for (int i = 0; i < splitArray.length; i++) {
            splitArray[i] = split.get(i) + String.format("%d>", totalParts);
        }
        return splitArray;
    }
}
