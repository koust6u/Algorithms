import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static int[] values;
    private static int[] arr;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        values = new int[N];
        arr = new int[M];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(values);
        backTracking(N, M, 0);
        System.out.println(sb);
    }

    private static void backTracking(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = values[i];
                backTracking(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
