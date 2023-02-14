package medium;

public class M394DecodeString {
    private int index = 0;

    public String decodeString(String s) {
        StringBuilder decode = new StringBuilder();
        int times = 0;

        while (index < s.length()) {
            while (index < s.length() && Character.isLetter(s.charAt(index))) {
                decode.append(s.charAt(index));
                index++;
            }

            if (index >= s.length() || s.charAt(index) == ']') {
                index++;
                break;
            } else if (s.charAt(index) == '[') {
                index++;
                String nested = decodeString(s);
                decode.append(nested.repeat(times));
                times = 0;
            } else {
                StringBuilder sTimes = new StringBuilder();
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    sTimes.append(s.charAt(index));
                    index++;
                }
                times = Integer.parseInt(sTimes.toString());
            }
        }
        return decode.toString();
    }
}
