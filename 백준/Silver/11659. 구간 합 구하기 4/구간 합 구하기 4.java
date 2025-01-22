import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = scanner.nextInt();
        int iter = scanner.nextInt();

        int[] nums = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            nums[i] = nums[i - 1] + scanner.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iter; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            sb.append(nums[end] - nums[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
