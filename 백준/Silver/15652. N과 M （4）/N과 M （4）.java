import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer s = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(s.nextToken());
        int M = Integer.parseInt(s.nextToken());

        arr = new int[M];
        backTracking(N, M, 0, 0);
        System.out.println(sb);
    }

    private static void backTracking(int N, int M, int depth, int prev) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (prev <= i) {
                arr[depth] = i + 1;
                backTracking(N, M, depth + 1, i);
            }
        }
    }
}
