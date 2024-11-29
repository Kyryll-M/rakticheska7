import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Розмір матриці буде 5 на 5");

        int size = 5;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Введіть значення елементу (" + i + "," + j + ") матриці");
                matrix[i][j] = s.nextInt();
            }
        }

        System.out.println("Матриця з вашими даними:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int determinant = calculateDeterminant(matrix);
        System.out.println("\nВизначник матриці: " + determinant);
    }

    public static int calculateDeterminant(int[][] matrix) {
        int size = matrix.length;
        int det = 1;

        for (int i = 0; i < size; i++) {
            if (matrix[i][i] == 0) {
                boolean swapped = false;
                for (int j = i + 1; j < size; j++) {
                    if (matrix[j][i] != 0) {
                        int[] temp = matrix[i];
                        matrix[i] = matrix[j];
                        matrix[j] = temp;
                        det *= -1;
                        swapped = true;
                        break;
                    }
                }
                if (!swapped) {
                    return 0;
                }
            }

            for (int j = i + 1; j < size; j++) {
                if (matrix[j][i] != 0) {
                    int factor = matrix[j][i] / matrix[i][i];
                    for (int k = i; k < size; k++) {
                        matrix[j][k] -= factor * matrix[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            det *= matrix[i][i];
        }

        return det;
    }
}