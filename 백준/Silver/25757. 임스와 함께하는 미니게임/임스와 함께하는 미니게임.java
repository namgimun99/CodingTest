import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int result = 0;

        Set<String> set = new HashSet<>();

        for(int i = 0; i < num; i++) {
            set.add(br.readLine());
        }
        
        if("Y".equals(game)) {
            result = set.size();
        } else if("F".equals(game)) {
            result = set.size() / 2;
        } else if("O".equals(game)) {
            result = set.size() / 3;
        }

        System.out.println(result);

        br.close();

    }
}
