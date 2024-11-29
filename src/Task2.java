import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків масиву: ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців масиву: ");
        int cols = scanner.nextInt();

        Random rand = new Random();
        double[][] array = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = rand.nextDouble() * 100;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 != 0 || j % 2 != 0) {
                    array[i][j] = Math.sqrt(array[i][j]);
                }
            }
        }

        System.out.println("Модифікований масив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f ", array[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
