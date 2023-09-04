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
        int max = 0;

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i< N; i++){
            sum = sum + Integer.parseInt(st.nextToken());
            list.add(sum);
        }

        for(int i = 0; i<list.size(); i++){
            if(i == K-1){
                max = list.get(i);
            } else if(i > K-1) {
                max = (list.get(i)-list.get(i-K)) > max? (list.get(i)-list.get(i-K)) : max;
            }
        }

        pw.println(max);

        pw.close();
        br.close();

    }
}
