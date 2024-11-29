import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рівнів піраміди: ");
        int levels = scanner.nextInt();

        int[][] pyramid = new int[levels][];
        for (int i = 0; i < levels; i++) {
            pyramid[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                pyramid[i][j] = (i + 1) * (j + 1);
            }
        }

        System.out.println("\nПіраміда у звичайному порядку:");
        for (int i = 0; i < pyramid.length; i++) {
            printLevel(pyramid[i]);
        }

        System.out.println("\nПіраміда у зворотньому порядку:");
        for (int i = pyramid.length - 1; i >= 0; i--) {
            printLevel(pyramid[i]);
        }

        scanner.close();
    }

    private static void printLevel(int[] level) {
        for (int value : level) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}