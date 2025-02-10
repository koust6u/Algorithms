
import java.io.*;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();
        int i = scanner.nextInt();
        System.out.println(a.charAt(i-1));
    }
}
