import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int num = Integer.parseInt(br.readLine());
        int[] A = new int[num];
        int[] B = new int[num];
        int sum = 0;
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < num; j++) {
            A[j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < num; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B);
        Arrays.sort(A);

        for(int i = 0 ; i< num ; i++) {
            sum += A[i] * B[num-1-i];
        }
        
        pw.println(sum);
        pw.close();
        br.close();
    }
}
