import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[] use;
    private static int result = 0;

    public static void main(String[] args) {
        int plug = scanner.nextInt();
        int devices = scanner.nextInt();
        int[] plan = new int[devices];
        use = new int[plug];
        for (int i = 0; i < devices; i++) {
            plan[i] = scanner.nextInt();
        }

        for (int i = 0; i < devices; i++) {
            find(plan[i], i, plan);
        }

        System.out.println(result);
    }

    private static void find(final int current, final int currentIndex, final int[] plan) {
        for (int i = 0; i < use.length; i++) {
            if (use[i] == current) {
                return;
            }
        }

        for (int i = 0; i < use.length; i++) {
            if (use[i] == 0) {
                use[i] = current;
                return;
            }
        }
        final int willRemove = maxDistanceIndex(plan, currentIndex);
        use[willRemove] = current;
    }

    private static int maxDistanceIndex(final int[] plan, final int index) {
        int answer = 0;
        int distance = 0;
        for (int i = 0; i < use.length; i++) {
            int temp = 0;
            for (int j = index + 1; j < plan.length; j++) {
                if (use[i] == plan[j]) {
                    break;
                }
                temp++;
                if (j == plan.length - 1) {
                    result++;
                    return i;
                }
            }
            if (distance <= temp) {
                distance = temp;
                answer = i;
            }
        }
        result++;
        return answer;
    }
}
