package easy;

public class E171ExcelColumnNumber {

    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int number = 0;
        for (int i = 0; i < n; i++) {
            int curr = columnTitle.charAt(i) - 'A' + 1;
            int power = n - i - 1;
            number += curr * (int) Math.pow(26, power);
        }
        return number;
    }

    public int titleToNumber2(String columnTitle) {
        int n = columnTitle.length();
        int number = 0;
        for (int i = 0; i < n; i++) {
            number *= 26;
            number += columnTitle.charAt(i) - 'A' + 1;
        }
        return number;
    }
}
