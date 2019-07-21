import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

    static int shortest(int[] c, int i) {
        if (i < 0)
            return Integer.MAX_VALUE;

        if (c[i] == 1)
            return Integer.MAX_VALUE;

        if (i == 0)
            return 0;

        int oneStep = shortest(c, i - 1);
        int twoStep = shortest(c, i - 2);

        if (oneStep < twoStep)
            return oneStep + 1;

        return twoStep + 1;
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        return JumpingOnTheClouds.shortest(c, c.length - 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
