package easy;

public class E1009ComplementBase10 {

    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        char[] chars = binary.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') chars[i] = '1';
            else chars[i] = '0';
        }
        return Integer.parseInt(String.valueOf(chars), 2);
    }
}
