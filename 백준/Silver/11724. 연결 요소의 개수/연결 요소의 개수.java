import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] board = new int[n+1][n+1];

        for(int i = 0; i< k; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            board[num1][num2] = 1;
            board[num2][num1] = 1;
        }


        boolean[] visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;

        for(int i = 1; i<=n; i++){
            if(!visit[i]) {
                cnt++;
                queue.offer(i);
                visit[i] = true;;
                while(!queue.isEmpty()) {
                    int current = queue.poll();

                    for(int j = 1; j<= n; j++){
                        if(board[current][j] == 1 && !visit[j]) {
                            queue.offer(j);
                            visit[j] = true;
                        }
                    }
                }
            }
        }

        pw.println(cnt);

        br.close();
        pw.close();

    }
}
