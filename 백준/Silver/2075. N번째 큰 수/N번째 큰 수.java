import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i< num; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< num; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        while(pq.size() != num) {
            pq.remove();
        }

        System.out.println(pq.peek());

        br.close();
    }
}
