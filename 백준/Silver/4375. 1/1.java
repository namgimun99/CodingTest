import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        List<String> numList = new ArrayList<>();

        String input;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }
            numList.add(input);
        }

        for (int i = 0; i < numList.size(); i++) {
            count = 1;
            find1(new BigInteger("1"), new BigInteger(numList.get(i)));

        }

        pw.close();
        br.close();
    }

    private static void find1(BigInteger strNum, BigInteger num) {
        if (strNum.remainder(num).compareTo(BigInteger.ZERO) == 0) {
            System.out.println(count);
            return;
        }

        count++;
        find1(strNum.multiply(BigInteger.TEN).add(BigInteger.ONE), num);
    }
}