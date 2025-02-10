import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] CORRECT = new int[]{1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            int a = Integer.parseInt(st.nextToken());
            System.out.print(CORRECT[i] - a + " ");
        }
    }
}
