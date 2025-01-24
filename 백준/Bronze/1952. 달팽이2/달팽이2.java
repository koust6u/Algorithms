import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Direction direction = Direction.Right;
    private static boolean[][] visit;
    private static int m;
    private static int n;
    private static int answer = 0;

    public static void main(String[] args) {
        m = scanner.nextInt();
        n = scanner.nextInt();
        visit = new boolean[m][n];
        int[] points = new int[]{0, 0};
        while (direction != Direction.Complete) {
            points = goAhead(points[0], points[1]);
            direction = findDirection(points[0], points[1]);
            if (direction != Direction.Complete) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static int[] goAhead(int x, int y) {
        while (x >= 0 && x < n && y >= 0 && y < m && !visit[y][x]) {
            visit[y][x] = true;
            y += direction.y;
            x += direction.x;
        }
        visit[y - direction.y][x - direction.x] = false;
        return new int[]{x - direction.x, y - direction.y};
    }

    private static Direction findDirection(int x, int y) {
        if (x + 1 < n && y >= 0 && y < m && !visit[y][x + 1]) {
            return Direction.Right;
        }
        if (x - 1 >= 0 && y >= 0 && y < m && !visit[y][x - 1]) {
            return Direction.Left;
        }
        if (y + 1 < m && x >= 0 && x < n && !visit[y + 1][x]) {
            return Direction.Up;
        }
        if (y - 1 >= 0 && x >= 0 && x < n && !visit[y - 1][x]) {
            return Direction.Down;
        }
        return Direction.Complete;
    }

    enum Direction {
        Complete(0, 0),
        Left(-1, 0),
        Right(1, 0),
        Up(0, 1),
        Down(0, -1);

        private final int x;
        private final int y;

        Direction(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}
