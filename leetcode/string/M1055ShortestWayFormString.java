package string;

public class M1055ShortestWayFormString {

    public int shortestWay(String source, String target) {
        int steps = 0, targetIndex = 0;

        while (targetIndex < target.length()) {
            int tempIndex = targetIndex;

            for (int sourceIndex = 0; sourceIndex < source.length(); sourceIndex++) {
                if (targetIndex < target.length() && target.charAt(targetIndex) == source.charAt(sourceIndex)) {
                    targetIndex++;
                }
            }

            if (tempIndex == targetIndex) return -1;
            steps++;
        }
        return steps;
    }
}
