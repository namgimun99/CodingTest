import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int sum;
    static int[] answer;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weight = new int[n];
        answer = new int[n];
        int[] LR = {0,1,2};
        sum = 0;

        for(int i = 0; i<n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
            sum += weight[i];
        }

        ans = new int[sum];
        int cnt = 0;
        canMake(0,LR, weight);

        for(int i = 0; i<ans.length; i++){
            if(ans[i] == 0) {
                cnt++;
            }
        }
        
        pw.println(cnt);

        br.close();
        pw.close();

    }

    public static void canMake(int cnt, int[] LR, int[] weight) {
        if(cnt == n) {
            int result = 0;
            for(int i = 0; i<answer.length; i++){
                if(answer[i] == 1) {
                    result -= weight[i];
                } else if(answer[i] == 2) {
                    result += weight[i];
                }

                if(result > 0 && result <=sum) {
                    ans[result-1] = 1;
                }
            }
            return;
        }

        for(int i = 0; i<LR.length; i++){
            answer[cnt] = LR[i];
            canMake(cnt+1,LR, weight);
        }

    }
}
