import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        System.out.println(divideAndConquer(a, b, c) % c);
    }

    private static long divideAndConquer(long base, long exponent, long divide) {
        if (exponent < 2) {
            return base % divide;
        }
        final long temp = divideAndConquer(base, exponent / 2, divide);
        if (exponent % 2 == 0) {
            return temp
                    * temp % divide;
        }
        return temp
                * divideAndConquer(base, exponent / 2 + 1, divide) % divide;
    }
}
