import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NewYearChaos {
    private static HashMap<Integer, Integer> hs = new HashMap<>();

    static void minimumBribes(int[] q) {
        hs = new HashMap<>();

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

//            insertion(q1, actualRank, oldRank);
        }

        System.out.print(totalNoOfBribes);
    }

    static void minimumBribesSimpler(int[] q) {

        int totalNoOfBribes = 0;

        for (int i = q.length - 1; i >= 0; i--) {
            int bribes = 0;

            for (int j = i + 1; j < q.length; j++) {
                if (q[i] > q[j])
                    bribes++;

                if (bribes > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
            }

            totalNoOfBribes += bribes;
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
