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
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 0; i< n; i++){
          list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        int k = Integer.parseInt(br.readLine());
        int i=0;
        int j = list.size() -1;

        while(true){
            if(i >= j) {
                break;
            }

            if(list.get(i) + list.get(j) == k) {
                i++;
                j--;
                cnt++;
            } else if(list.get(i) + list.get(j) > k) {
                j--;
            } else {
                i++;
            }
        }

        pw.println(cnt);

        br.close();
        pw.close();
    }
}
