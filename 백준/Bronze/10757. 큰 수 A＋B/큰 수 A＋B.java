
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(scanner.next());
        BigDecimal b2 = new BigDecimal(scanner.next());

        BigDecimal add = b1.add(b2);
        System.out.println(add);
    }
}
