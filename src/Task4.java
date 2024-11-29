import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Введіть розмір матриці (n x n): ");
        int size = s.nextInt();

        int[][] matrix = new int[size][size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rand.nextInt(10) + 1;  // Випадкові числа від 1 до 10
            }
        }

        System.out.println("Матриця з випадковими значеннями:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Введіть рядок та стовпчик для вибору елемента, для якого буде обчислено мінор:");
        int row = s.nextInt() - 1;
        int col = s.nextInt() - 1;

        int[][] minor = getMinor(matrix, row, col);
        int minorDeterminant = calculateDeterminant(minor);

        System.out.println("Мінор матриці для елемента (" + (row + 1) + ", " + (col + 1) + "):");
        for (int i = 0; i < minor.length; i++) {
            for (int j = 0; j < minor.length; j++) {
                System.out.print(minor[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Визначник мінору: " + minorDeterminant);
    }

    public static int[][] getMinor(int[][] matrix, int row, int col) {
        int size = matrix.length;
        int[][] minor = new int[size - 1][size - 1];
        int r = 0, c;

        for (int i = 0; i < size; i++) {
            if (i == row) continue;
            c = 0;
            for (int j = 0; j < size; j++) {
                if (j == col) continue;
                minor[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }

        return minor;
    }

    public static int calculateDeterminant(int[][] matrix) {
        int size = matrix.length;
        int det = 1;

        if (size == 1) {
            return matrix[0][0];
        } else if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            for (int i = 0; i < size; i++) {
                int[][] subMatrix = new int[size - 1][size - 1];
                for (int j = 1; j < size; j++) {
                    int subCol = 0;
                    for (int k = 0; k < size; k++) {
                        if (k == i) continue;
                        subMatrix[j - 1][subCol] = matrix[j][k];
                        subCol++;
                    }
                }
                det += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(subMatrix);
            }
        }
        return det;
    }
}