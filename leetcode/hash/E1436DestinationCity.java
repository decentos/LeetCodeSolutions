package hash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E1436DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<>();

        for (List<String> path : paths) {
            from.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!from.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
