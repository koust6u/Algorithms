import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int count = scanner.nextInt();
        final int[] localBudgets = new int[count];
        for (int i = 0; i < count; i++) {
            localBudgets[i] = scanner.nextInt();
        }
        final int totalBudget = scanner.nextInt();
        Arrays.sort(localBudgets);

        System.out.println(findFitBudget(localBudgets, totalBudget));
    }

    private static int findFitBudget(final int[] budgets, final int maxBudget) {
        int index = (budgets[budgets.length - 1]);

        while (index > 0) {
            final int profit = calculateBudget(budgets, index);
            if (maxBudget >= profit) {
                return index;
            }
            index--;
        }
        return 0;
    }

    private static int calculateBudget(final int[] budgets, final int bound) {
        int answer = 0;
        for (int budget : budgets) {
            answer += Math.min(budget, bound);
        }
        return answer;
    }
}
