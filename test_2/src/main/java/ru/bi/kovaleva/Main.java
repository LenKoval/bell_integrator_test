package ru.bi.kovaleva;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {5, 7, 9, 2, 1},
                {0, 9, 1, 8, 7},
                {6, 3, 6, 6, 6},
                {99, 100, -2, 3, 1}
        };

        findDiagonalsMin(arr);
    }

    private static void findDiagonalsMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;


        int n = matrix.length;
        if (n == 0) {
            System.out.println("Матрица не заполнена.");
        }

        for (int i = 0, j = matrix.length-1; i < matrix.length; i++, j--) {
            if (j != matrix.length / 2) {
                min = Math.min(matrix[i][j], min);
            }
        }

        System.out.println("Наименьший элемент диагонали: " + min);
    }
}
