import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[] answer;

    public static void main(String[] args) {
        int number = scanner.nextInt();
        List<Integer> history = new ArrayList<>();
        answer = new int[number];

        for (int i = 0; i < number; i++) {
            history.add(scanner.nextInt());
        }

        for (int i = 0; i < number; i++) {
            int position = batch(history.get(i), i + 1);
            answer[position] = i + 1;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i != answer.length - 1) {
                System.out.print(" ");
            }
        }
    }

    private static int batch(int sequence, int height) {
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) { // 아직 배치되지 않은 위치
                if (sequence == 0) {
                    return i;
                }
                sequence--; // 남은 큰 사람 수 감소
            }
        }
        throw new IllegalStateException("적절한 위치를 찾을 수 없습니다.");
    }
}
