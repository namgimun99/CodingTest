import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        int num = 0;
        int last = 0;

        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i< N; i++){
            num = Integer.parseInt(st.nextToken());
            list.add(num);
            set.add(num);

            map.putIfAbsent(num, 0);
        }

        while(!set.isEmpty()){
            last = set.pollLast();
            map.put(last, set.size());
        }

        for(int i = 0; i<list.size(); i++){
            pw.print(map.get(list.get(i)) + " ");
        }


        pw.close();
        br.close();

    }
}
