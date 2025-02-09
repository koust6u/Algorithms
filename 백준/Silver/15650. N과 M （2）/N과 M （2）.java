
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean[] visit;
    private static int[] arr;

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        backTracking(N, M, 0, -1);
    }

    private static void backTracking(int N, int M, int depth, int prev) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && prev < i) {
                visit[i] = true;
                arr[depth] = i + 1;
                backTracking(N, M, depth + 1, i);
                visit[i] = false;
            }
        }
    }
}
