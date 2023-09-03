import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = 0;
        int result = 0;

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i< N; i++){
            sum = sum + Integer.parseInt(st.nextToken());
            list.add(sum);
        }

        for(int i = 0; i< K; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == 1) {
                pw.println(list.get(end-1));
            } else {
                result = list.get(end-1)-list.get(start-2);
                pw.println(result);
            }
        }

        pw.close();
        br.close();

    }
}
