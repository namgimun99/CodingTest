import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int startidx = 0;
        int start = 0;
        int endidx = 0;

        TreeSet<Integer> startSet = new TreeSet<>();
        TreeSet<Integer> endSet = new TreeSet<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            startSet.add(Integer.parseInt(st.nextToken()));
            endSet.add(Integer.parseInt(st.nextToken()));
        }

        while(true){
            startidx  = startSet.pollFirst();
            start = startidx > start ? startidx : start;

            endidx = endSet.pollFirst();
            while(true){
                if(start < endidx) {
                    start = start + L;
                    cnt++;
                }

                else {
                    break;
                }
            }
            if(startSet.isEmpty()){
                break;
            }
        }

        pw.println(cnt);



        pw.close();
        br.close();

    }
}
