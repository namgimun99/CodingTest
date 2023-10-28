import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num; // 숫자 배열
    static int[] ans; //정답 배열
    static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        ans = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        nCr(0,0);
    }

    private static void nCr(int cnt, int start) { // 갯수와 시작 위치를 넣는다.
        if (cnt == m) { // 갯수만큼 뽑았으면 출력한다.
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< ans.length; i++){
                sb.append(ans[i]);
                if(i<ans.length-1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = start; i < num.length; i++) { // 시작위치부터 끝까지 돌린다.
            ans[cnt] = num[i];  // 현재위치의 숫자를 답 배열에 넣는다.
            nCr(cnt + 1, i + 1); // 현재 위치를 1 더한 후 다음 숫자를 찾는다.
        }
    }
}