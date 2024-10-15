package string;

public class E58LengthLastWord {

    public int lengthOfLastWord(String s) {
        int lenght = 0;
        int index = s.length() - 1;

        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
            lenght++;
        }
        return lenght;
    }
}
