package string;

public class M2109AddingSpacesToString {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder withSpaces = new StringBuilder();
        int spaceIndex = 0;

        for (int sIndex = 0; sIndex < s.length(); sIndex++) {
            if (spaceIndex < spaces.length && spaces[spaceIndex] == sIndex) {
                withSpaces.append(' ');
                spaceIndex++;
            }
            withSpaces.append(s.charAt(sIndex));
        }
        return withSpaces.toString();
    }
}
