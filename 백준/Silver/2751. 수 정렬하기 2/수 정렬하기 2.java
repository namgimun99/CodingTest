import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        TreeSet<Integer> treeSet = new TreeSet<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i< num; i++){
            treeSet.add(Integer.parseInt(br.readLine()));
        }

        for(int N :treeSet){
            pw.println(N);
        }

        pw.close();
        br.close();

    }
}
