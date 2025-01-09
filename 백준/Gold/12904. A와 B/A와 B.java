import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String origin = scanner.nextLine();
        String target = scanner.nextLine();

        while(origin.length() != target.length()) {
            target = trim(target);
        }

        if (target.equals(origin)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

    private static String trim(final String target) {
        if (target.charAt(target.length()-1) == 'A') {
            return target.substring(0, target.length() -1);
        }
        final String reverse = target.substring(0, target.length() -1);
        final StringBuilder sb = new StringBuilder(reverse);
        return sb.reverse().toString();
    }
}
