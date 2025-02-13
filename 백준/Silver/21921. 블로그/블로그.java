
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        long max = 0;
        long count = 1;
        long window = 0;
        for (int i = 0; i < m; i++) {
            window += arr[i];
        }
        max = window;
        for (int i = m; i < n; i++) {
            window -= arr[i - m];
            window += arr[i];
            if (window > max) {
                max = window;
                count = 0;
            }
            if (window == max) {
                count++;
            }
        }

        if (max == 0) {
            bw.write("SAD");
            bw.flush();
        } else {
            bw.write(max + "\n" + count);
            bw.flush();
        }
    }
}
