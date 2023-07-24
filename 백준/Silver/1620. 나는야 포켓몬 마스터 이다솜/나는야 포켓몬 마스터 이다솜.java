import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        String exam = " ";
        String poketmon = " ";
        String[] parts = br.readLine().split(" ");

        for(int i = 0; i<Integer.parseInt(parts[0]); i++) {
            poketmon = br.readLine();
            map.put(String.valueOf(i+1),poketmon);
            map2.put(poketmon,String.valueOf(i+1));
        }

        for(int i = 0; i<Integer.parseInt(parts[1]); i++) {
            exam = br.readLine();
            if(map.containsKey(exam)) {
                pw.println(map.get(exam));
            }

            else {
                pw.println(map2.get(exam));
            }
        }

        pw.close();
        br.close();


    }
}
