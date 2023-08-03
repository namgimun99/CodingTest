import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, TreeSet<String>> map = new TreeMap<>();

        int num = Integer.parseInt(br.readLine());
        String str = "";

        for(int i = 0; i< num; i++){
            str = br.readLine();

            map.putIfAbsent(str.length(),new TreeSet<>());
            map.get(str.length()).add(str);

        }

        Collection<TreeSet<String>> values = map.values();
        for (TreeSet<String> valueSet : values) {
            for (String value : valueSet) {
                pw.println(value);
            }
        }


        pw.close();
        br.close();
    }
}
