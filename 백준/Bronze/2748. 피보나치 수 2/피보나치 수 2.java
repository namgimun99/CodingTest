import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        if(n >= 2) {
            long[] dpArr = new long[n+1];
            dpArr[0] = 0;
            dpArr[1] = 1;

            for(int i = 2; i<= n; i++) {
                dpArr[i] = dpArr[i-1] + dpArr[i-2];
            }

            answer = dpArr[n];
        } else {
            answer = n == 1 ? 1 : 0;
        }

        System.out.println(answer);

        br.close();
        pw.close();
    }
}
