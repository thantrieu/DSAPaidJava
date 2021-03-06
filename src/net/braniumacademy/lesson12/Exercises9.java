package net.braniumacademy.lesson12;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập cấp ma trận: ");
        var m = input.nextInt();
        var n = input.nextInt();
        var matrixA = new int[m][n];
        var matrixB = new int[m][n];
        System.out.println("Nhập ma trận A: ");
        fillMatrix(matrixA, input);
        System.out.println("Nhập ma trận B: ");
        fillMatrix(matrixB, input);
        var matrixSum = add(matrixA, matrixB);
        System.out.println("Ma trận A: ");
        onScreen(matrixA);
        System.out.println("Ma trận B: ");
        onScreen(matrixB);
        System.out.println("Ma trận tổng: ");
        onScreen(matrixSum);
    }

    /**
     * Phương thức hiển thị ma trận lên màn hình
     *
     * @param matrix ma trận chứa các phần tử cần hiển thị
     */
    private static void onScreen(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Phương thức tính tổng hai ma trận
     *
     * @param matrixA ma trận thứ nhất
     * @param matrixB ma trận thứ hai
     * @return ma trận tổng
     */
    private static int[][] add(int[][] matrixA, int[][] matrixB) {
        // ma trận tổng có cùng cấp với hai ma trận thành phần
        int[][] sum = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                sum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return sum;
    }

    /**
     * Phương thức dùng để nhập vào các phần tử cho ma trận
     *
     * @return mảng 2 chiều sau khi nhập
     */
    private static void fillMatrix(int[][] matrix, Scanner input) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = input.nextInt();
            }
        }
    }
}
