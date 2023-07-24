import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i = 0; i<=str.length(); i++){
            for(int j = i+1; j<=str.length(); j++){
                set.add(str.substring(i,j));
            }
        }

        pw.println(set.size());

        pw.close();
        br.close();

    }
}
