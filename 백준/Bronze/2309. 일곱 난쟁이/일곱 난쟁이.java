import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        List<Integer> list = new ArrayList<>();

        int sum = 0;
        boolean visit = false;

        for(int i = 0; i<9; i++){
            list.add(Integer.parseInt(br.readLine()));
            sum = sum + list.get(i);
        }

        for(int i = 0; i<list.size()-1; i++){
            for(int j = i+1; j<list.size(); j++){
                if(list.get(i) + list.get(j) == sum-100){
                    visit = true;
                    list.remove(list.get(j));
                    list.remove(list.get(i));
                    break;
                }
            }
            if(visit){
                break;
            }
        }

        Collections.sort(list);

        for(int i = 0; i< list.size(); i++){
            pw.println(list.get(i));
        }

        pw.close();
        br.close();

    }
}
