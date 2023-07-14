package design;

public class E604DesignCompressedStringIterator {
    int pointer, count, n;
    char curr;
    String compressed;

    public E604DesignCompressedStringIterator(String compressedString) {
        pointer = 0;
        count = 0;
        n = compressedString.length();
        curr = ' ';
        compressed = compressedString;
    }

    public char next() {
        if (!hasNext()) return ' ';

        if (count == 0) {
            curr = compressed.charAt(pointer++);
            while (pointer < n && Character.isDigit(compressed.charAt(pointer))) {
                count = count * 10 + compressed.charAt(pointer++) - '0';
            }
        }

        count--;
        return curr;
    }

    public boolean hasNext() {
        return pointer < n || count > 0;
    }
}
