
import java.io.*;

public class Main {
    private static int N; // N x N 체스판
    private static int[] board;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        solveNQueens(0);
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void solveNQueens(int row) {
        if (row == N) { // N개의 퀸을 모두 배치한 경우
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) { // 현재 위치에 퀸을 놓을 수 있는지 확인
                board[row] = col;   // 퀸 배치
                solveNQueens(row + 1); // 다음 행으로 이동
                board[row] = -1;    // 백트래킹 (이전 상태로 되돌리기)
            }
        }
    }

    // 현재 위치(row, col)에 퀸을 놓을 수 있는지 확인하는 함수
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col) return false; // 같은 열에 퀸이 있는 경우
            if (Math.abs(board[i] - col) == Math.abs(i - row)) return false; // 대각선에 퀸이 있는 경우
        }
        return true;
    }
}
