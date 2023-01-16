package me.decentos.leetcode.easy;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int current = image[sr][sc];
        image[sr][sc] = color;
        if (sr - 1 >= 0 && image[sr - 1][sc] == current && image[sr - 1][sc] != color) floodFill(image, sr - 1, sc, color);
        if (sr + 1 < image.length && image[sr + 1][sc] == current && image[sr + 1][sc] != color) floodFill(image, sr + 1, sc, color);
        if (sc - 1 >= 0 && image[sr][sc - 1] == current && image[sr][sc - 1] != color) floodFill(image, sr, sc - 1, color);
        if (sc + 1 < image[sr].length && image[sr][sc + 1] == current && image[sr][sc + 1] != color) floodFill(image, sr, sc + 1, color);
        return image;
    }
}
