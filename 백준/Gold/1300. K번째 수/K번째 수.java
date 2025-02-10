import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }

}
