import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();

        int num = Integer.parseInt(br.readLine());
        int age = 0;

        for(int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());

            map.putIfAbsent((age), new ArrayList<>());
            map.get(age).add(st.nextToken());
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
            int key = entry.getKey();
            ArrayList<String> values = entry.getValue();
            for (String value : values) {
                pw.println(key + " " + value);
            }
        }

        pw.close();
        br.close();
    }
}
