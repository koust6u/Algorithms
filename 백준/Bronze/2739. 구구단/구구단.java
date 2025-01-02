import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int num = scanner.nextInt();
        for(int i = 1; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + num*i);
        }
    }
}