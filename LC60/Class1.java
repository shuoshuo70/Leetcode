package LC60;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

 Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

 To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

 At the end, return the modified image.

 * Created by shuoshu on 2017/11/26.
 */
public class Class1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        helper(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    private void helper(int[][] image, int sr, int sc, int newColor, int preColor) {
        if (!isValid(image, sr, sc) || image[sr][sc] != preColor) {
            return;
        }

        image[sr][sc] = newColor;
        helper(image, sr, sc + 1, newColor, preColor);
        helper(image, sr, sc - 1, newColor, preColor);
        helper(image, sr + 1, sc, newColor, preColor);
        helper(image, sr - 1, sc, newColor, preColor);
    }

    private boolean isValid(int[][] image, int sr, int sc) {
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length;
    }
}
