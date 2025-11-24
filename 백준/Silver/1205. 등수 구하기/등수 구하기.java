import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Integer[] scoreBrd = new Integer[N];
        int rank = 1;

        if(N>0) {
            st = new StringTokenizer(br.readLine());
        }

        for(int i = 0; i< N; i++) {
            scoreBrd[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scoreBrd, Collections.reverseOrder());

        if(N == P && scoreBrd[scoreBrd.length-1] >= score) {
            rank =-1;
        } else {
            for(int i = 0 ; i< N; i++) {
                if(score < scoreBrd[i]) {
                    rank++;
                } else {
                    break;
                }
            }
        }

        System.out.println(rank);
        br.close();
    }
}
