import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int ppl1 = Integer.parseInt(st.nextToken());
        int ppl2 = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(ppl1 != ppl2) {
            ppl1 = ppl1/2 + ppl1%2;
            ppl2 = ppl2/2 + ppl2%2;
            cnt ++;
        }

        pw.println(cnt);
        br.close();
        pw.close();
    }
}