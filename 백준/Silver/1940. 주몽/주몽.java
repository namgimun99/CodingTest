import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        Set<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 0; i< n; i++){
          set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>(set);

        for(int i = 0; i<list.size(); i++) {
            for(int j = list.size()-1 ; j > i; j--){

                if(k - list.get(i) == list.get(j)) {
                    cnt++;
                    break;
                }

            }
        }

        pw.println(cnt);

        br.close();
        pw.close();
    }
}
