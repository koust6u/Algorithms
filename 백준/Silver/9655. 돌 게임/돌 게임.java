
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = scanner.nextInt();

        if (number % 2 == 1) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }
    }
}