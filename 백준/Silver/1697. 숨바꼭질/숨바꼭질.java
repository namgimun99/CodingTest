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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] board = new int[100001];
        board[n] = 1;

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(n);

        int time = 0;
        while (!queue1.isEmpty()) {
            int current = queue1.poll();

            if (current == k) {
                pw.println(board[current]-1);
            }

            if (current - 1 >= 0 && board[current - 1] == 0) {
                board[current - 1] = board[current]+1;
                queue1.offer(current - 1);
            }

            if (current + 1 <= 100000 && board[current + 1] == 0) {
                board[current + 1] = board[current]+1;
                queue1.offer(current + 1);
            }

            if (current * 2 <= 100000 && board[current * 2] == 0) {
                board[current * 2] = board[current]+1;
                queue1.offer(current * 2);
            }
        }

        br.close();
        pw.close();

    }
}
