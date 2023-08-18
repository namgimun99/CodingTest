import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int testcase = Integer.parseInt(br.readLine());
        int cloth = 0;
        int result = 1;

        HashMap<String, Integer> map = new HashMap<>();

        String part = "";
        String type = "";

        for(int i = 0; i< testcase; i++) {

            cloth = Integer.parseInt(br.readLine());

            for (int j = 0; j < cloth; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                type = st.nextToken();
                part = st.nextToken();

                map.putIfAbsent(part, 0);

                map.put(part, map.get(part) + 1 );
            }
            for(int n : map.values()){
                result = result * (n+1);
            }

            pw.println(result-1);
            map.clear();
            result = 1;
        }




        pw.close();
        br.close();

    }
}
