package string;

import java.util.Set;

public class E1903LargestOddNumber {

    public String largestOddNumber(String num) {
        Set<Character> oddChars = Set.of('1', '3', '5', '7', '9');
        int oddIndex = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            if (oddChars.contains(num.charAt(i))) {
                oddIndex = i + 1;
                break;
            }
        }
        return num.substring(0, oddIndex);
    }
}
