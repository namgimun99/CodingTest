
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<String> Tset = new TreeSet<>();

        int num = Integer.parseInt(st.nextToken());
        String name = " ";

        for(int i = 0; i< num; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            if(Tset.contains(name)) {
                Tset.remove(name);
            }
            else {
                Tset.add(name);
            }
        }
        while(!Tset.isEmpty()) {
            pw.println(Tset.pollLast());
        }


        pw.close();
        br.close();
    }
}
