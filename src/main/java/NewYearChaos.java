import java.util.Scanner;
import java.util.stream.IntStream;

public class NewYearChaos {
    static void minimumBribes(int[] q) {

        int totalNoOfBribes = 0;
        int[] q1 = IntStream.range(1, q.length + 1).toArray();

        for (int actualIndex = 0; actualIndex < q.length; actualIndex++) {
            int foundIndex = findNum(q1, q[actualIndex]);

            if (foundIndex <= actualIndex)
                continue;

            int bribe = foundIndex - actualIndex;

            if (bribe > 2) {
                System.out.print("Too chaotic");
                return;
            }

            totalNoOfBribes += bribe;

            insertion(q1, actualIndex, foundIndex);
        }

        System.out.print(totalNoOfBribes);
    }

    public static void insertion(int[] q, int i, int j) {
        int num = q[j];

        for (int k = j; k > i; k--) {
            q[k] = q[k - 1];
        }

        q[i] = num;
    }

    public static int findNum(int[] q, int n) {
        for (int i = 0; i < q.length; i++)
            if (q[i] == n)
                return i;

        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}