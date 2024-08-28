package string;

public class E1071GreatestCommonDivisor {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int divisorLength = findCommonDivisor(str1.length(), str2.length());
        return str1.substring(0, divisorLength);
    }

    private int findCommonDivisor(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}
