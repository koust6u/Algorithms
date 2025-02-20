import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String target = st.nextToken();
        int radix = Integer.parseInt(st.nextToken());
        long transformation = transformation(target, radix);
        bw.write(String.valueOf(transformation));
        bw.flush();
        bw.close();
    }

    private static long transformation(String source, int radix) {
        StringBuilder sb = new StringBuilder(source);
        long answer = 0L;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int value = sb.charAt(i) - '0';
            if (sb.charAt(i) > 58) {
                value = sb.charAt(i) - 'A' + 10;
            }
            answer += (long) value * Math.pow(radix, (sb.length() - i - 1));
        }
        return answer;
    }
}
