import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int[][] arr = new int[21][21];

        for(int i = 1; i <= 19; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= 19; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] x = {1,1,0,-1};
        int[] y = {0,1,1,1};
        int re = 0;
        int cnt = 0;
        int winner = 0;
        int[] winPoint = new int [2];

        for(int i = 1; i <= 19; i++){
            for(int j = 1; j <= 19; j++){
                if(arr[i][j] != 0) {
                    re = arr[i][j];
                    for(int k = 0; k<4; k++){
                        cnt = 1;
                        int moveX = i-(x[k]);
                        int moveY = j-(y[k]);

                        if(arr[moveX][moveY] == re) {
                            continue;
                        }

                        while(true) {

                            moveX = i+(x[k]*cnt);
                            moveY = j+(y[k]*cnt);

                            if(moveX < 1 || moveX > 19 ||moveY < 1 || moveY >19){
                                break;
                            }

                            if(arr[moveX][moveY] == re) {
                                cnt++;
                            } else {
                                break;
                            }
                        }

                        if(cnt == 5) {
                            winner = re;
                            winPoint[0] = i;
                            winPoint[1] = j;
                        }
                    }
                }

            }
        }
        pw.println(winner);
        if(winner != 0) {
            pw.print(winPoint[0] + " " + winPoint[1]);
        }

        pw.close();
        br.close();
    }
}