package string;

public class E2264Largest3Digit {

    public String largestGoodInteger(String num) {
        char largest = 0, curr = 0;
        int seq = 0;

        for (char c : num.toCharArray()) {
            if (c == curr) {
                seq++;
            } else {
                curr = c;
                seq = 1;
            }

            if (seq == 3 && curr > largest) {
                largest = curr;
            }
        }
        return largest > 0 ? new String(new char[]{largest, largest, largest}) : "";
    }
}
