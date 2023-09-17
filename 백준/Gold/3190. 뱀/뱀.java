import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
        public static <map> void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);

            int N = Integer.parseInt(br.readLine());
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] load = new int[N][N];
            int time = 0;
            load[0][0] = 1;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                load[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
            }

            int L = Integer.parseInt(br.readLine());
            Map<Integer, Character> map = new TreeMap<>() ;

            for (int i = 0; i < L; i++) {
                st = new StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
            }

            int snakeSee = 0;
            int HeadX = 0;
            int HeadY = 0;
            int[] x = {0,1,0,-1};
            int[] y = {1,0,-1,0};

            Deque<Integer> arrDeq = new LinkedList<>();

            arrDeq.offerFirst(0);
            arrDeq.offerFirst(0);

            while(true) {
                time++;
                
                HeadX += x[snakeSee % 4];
                HeadY += y[snakeSee % 4];

                arrDeq.offerFirst(HeadX);
                arrDeq.offerFirst(HeadY);

                if(HeadX > N-1 || HeadY > N-1 || HeadX < 0 || HeadY < 0) {
                    break;
                }


                if(load[HeadX][HeadY] == 1) {
                    break;
                } else {
                    if(load[HeadX][HeadY] == 0) {
                        load[arrDeq.pollLast()][arrDeq.pollLast()] = 0;
                    }

                    load[HeadX][HeadY] = 1;
                }

                if(map.containsKey(time)) {
                    if(map.get(time) == 'D') {
                        snakeSee++;
                    } else {
                        snakeSee += 3;
                    }
                }

            }

            pw.println(time);

            br.close();
            pw.close();
    }
}
