
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());

        int[] numArray = new int[10001];
        int num = 0;

        for(int i = 0; i<N; i++){
            num = Integer.parseInt(br.readLine());

            numArray[num] = numArray[num] + 1;

        }

        for(int i = 0; i<10001; i++){
            for(int j = 0; j < numArray[i]; j++){
                pw.println(i);
            }
        }

        pw.close();
        br.close();
    }
}
