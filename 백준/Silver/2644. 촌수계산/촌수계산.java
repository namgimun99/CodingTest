import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int[] check = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        check[0] = Integer.parseInt(st.nextToken());
        check[1] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int[][] board = new int[n+1][n+1];

        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            board[num1][num2] = 1;
            board[num2][num1] = 1;
        }

        boolean[] visit = new boolean[n+1];
        int[] counting = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(check[0]);
        visit[check[0]] = true;
        counting[check[0]] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == check[1]) {
                pw.println(counting[current]);
                break;
            }

            for(int i = 1; i<= n; i++){
                if(board[current][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    counting[i] = counting[current]+1;
                    visit[i] = true;
                }
            }
        }

        if(!visit[check[1]]) {
            pw.println(-1);
        }


        br.close();
        pw.close();

    }
}
