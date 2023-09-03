import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;

        int[][] array = new int[N][N];

        for(int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                if(j == 0) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    array[i][j] = array[i][j-1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        int x1,x2,y1,y2;

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken())-1;
            y1 = Integer.parseInt(st.nextToken())-1;
            x2 = Integer.parseInt(st.nextToken())-1;
            y2 = Integer.parseInt(st.nextToken())-1;

            if(x1 == x2) {
                if(y1 == 0 || y2 == 0) {
                    pw.println(array[x1][y2]);
                } else {
                    pw.println(array[x1][y2] - array[x1][y1-1]);
                }

            } else {
                if(y1 == 0 || y2 == 0) {
                    for(int j = x1; j <= x2; j++){
                        result = result + array[j][y2];
                    }
                    pw.println(result);
                } else {
                    for(int j = x1; j <= x2; j++){
                        result = result + array[j][y2] - array[j][y1-1];
                    }
                    pw.println(result);
                }
            }
            result = 0;
        }

        pw.close();
        br.close();

    }
}
