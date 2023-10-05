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

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int cnt = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());

                if(num == 1) {
                    list.add(i);
                }

            }

            for(int i = 0; i< list.size(); i++){
                if(i+k-1 >= list.size()) {
                    break;
                }

                cnt = list.get(i+k-1) - list.get(i) < cnt ? list.get(i+k-1) - list.get(i) : cnt;
            }

            if(list.size() < k) {
                pw.println(-1);
            } else {
                pw.println(cnt+1);
            }
            

            br.close();
            pw.close();
    }
}
