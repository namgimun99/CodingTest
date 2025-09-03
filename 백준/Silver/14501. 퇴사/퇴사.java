import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] days = new int[num];
        int[] pay = new int[num];

        StringTokenizer st;

        for(int i = 0; i< num; i++) {
            st = new StringTokenizer(br.readLine());

            days[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[num+1];

        for(int i=0;i<num;i++) {
            if(i+days[i]<=num) {	//범위에 벗어나지 않는다면
                dp[i+days[i]]=Math.max(dp[i+days[i]],dp[i]+pay[i]);
            }//if
            dp[i+1]=Math.max(dp[i+1],dp[i]);

        }//for
        System.out.println(dp[num]);


        br.close();
    }
}
