package matrix;

public class E733FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int curr = image[sr][sc];
        image[sr][sc] =  color;
        if (sr - 1 >= 0 && image[sr - 1][sc] == curr && image[sr - 1][sc] != color) floodFill(image, sr - 1, sc, color);
        if (sr + 1 < image.length && image[sr + 1][sc] == curr && image[sr + 1][sc] != color) floodFill(image, sr + 1, sc, color);
        if (sc - 1 >= 0 && image[sr][sc - 1] == curr && image[sr][sc - 1] != color) floodFill(image, sr, sc - 1, color);
        if (sc + 1 < image[0].length && image[sr][sc + 1] == curr && image[sr][sc + 1] != color) floodFill(image, sr, sc + 1, color);
        return image;
    }
}
