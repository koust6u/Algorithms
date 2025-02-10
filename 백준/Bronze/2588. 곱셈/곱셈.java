import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        StringBuilder b = new StringBuilder(br.readLine()).reverse();

        for (int i = 0; i < b.length(); i++) {
            int temp = b.charAt(i) - '0';
            sb.append(temp * a).append("\n");
        }
        StringBuilder origin = b.reverse();
        int originNumber = Integer.parseInt(origin.toString());
        sb.append(a * originNumber);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
