package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class E734SentenceSimilarity {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        Map<String, Set<String>> similarMap = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String w1 = pair.get(0), w2 = pair.get(1);
            similarMap.computeIfAbsent(w1, val -> new HashSet<>()).add(w2);
            similarMap.computeIfAbsent(w2, val -> new HashSet<>()).add(w1);
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i], w2 = sentence2[i];

            if (w1.equals(w2)) continue;
            if (similarMap.containsKey(w1) && similarMap.get(w1).contains(w2)) continue;
            if (similarMap.containsKey(w2) && similarMap.get(w2).contains(w1)) continue;

            return false;
        }

        return true;
    }
}
