package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class M535EncodeDecodeTinyURL {
    private final Map<String, String> shortUrls = new HashMap<>();
    private final Map<String, String> longUrls = new HashMap<>();
    private final Random random = new Random();
    private final char[] alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String encode(String longUrl) {
        if (longUrls.containsKey(longUrl)) return longUrls.get(longUrl);

        String key = generateKey();
        while (shortUrls.containsKey(key)) key = generateKey();

        shortUrls.put(key, longUrl);
        longUrls.put(longUrl, key);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        String key = shortUrl.replace("http://tinyurl.com/", "");
        return shortUrls.get(key);
    }

    private String generateKey() {
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            char letter = alphabet[random.nextInt(62)];
            shortUrl.append(letter);
        }
        return shortUrl.toString();
    }
}
