import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[][] map;
    static int[][] dp;
    static boolean[][] visit;
    static int col;
    static int max = 0;
    static int row;

    public static void main(String[] args) {
        col = scanner.nextInt();
        row = scanner.nextInt();
        map = new int[col][row];
        dp = new int[col][row];
        visit = new boolean[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int count = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }


    static void dfs(int x, int y) {
        int current = 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(x, y));
        visit[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int cx = queue.peek().get(0);
            int cy = queue.poll().get(1);
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < col && ny >= 0 && ny < row && !visit[nx][ny] && map[nx][ny] == 1) {
                    current++;
                    visit[nx][ny] = true;
                    dp[nx][ny] = dp[cx][cy] + 1;
                    queue.add(List.of(nx, ny));
                }
            }
        }
        if (max < current) {
            max = current;
        }
    }

}
