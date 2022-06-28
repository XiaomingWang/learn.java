package array;

import java.util.Arrays;

/**
 *
 * 48. Rotate Image
 *
 * ou are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if (j == i) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int pivot = (n + 1) / 2 - 1;
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= pivot; j++) {
                    int temp = matrix[i][pivot + j];
                    matrix[i][pivot + j] = matrix[i][pivot - j];
                    matrix[i][pivot - j] = temp;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= pivot; j++) {
                    int temp = matrix[i][pivot + j + 1];
                    matrix[i][pivot + j + 1] = matrix[i][pivot - j];
                    matrix[i][pivot - j] = temp;
                }
            }
        }


    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage solution = new RotateImage();
        solution.rotate(matrix);

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        solution.rotate(matrix);

        System.out.println(Arrays.toString(matrix));
    }


}
