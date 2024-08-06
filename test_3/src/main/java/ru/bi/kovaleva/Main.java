package ru.bi.kovaleva;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите число от 1 до 3: ");

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        switch (size) {
            case 1 :
                fillMatrix(4);
                break;
            case 2 :
                fillMatrix(6);
                break;
            case 3 :
                fillMatrix(8);
                break;
        }

        scanner.close();
    }

    public static void fillMatrix(int length) {
        int[][] matrix = new int[length][length];
        int index = length / 2;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i - index;
                matrix[j][matrix.length - 1 - i] = i - index;
                matrix[j][i] = i - index;
                matrix[matrix.length - i - 1][j] = i - index;
            }
        }

        Arrays.stream(matrix).forEach(num -> System.out.println(Arrays.toString(num)));
    }
}
