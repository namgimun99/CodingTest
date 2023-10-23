import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visit;
    static int[] ans;
    static int[] num;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        ans = new int[m];
        visit = new boolean[n];

        for(int i = 0; i< n; i++){
            num[i] = i+1;
        }

        NM(0);

        pw.close();
        br.close();

    }

    public static void NM(int cnt) {
		if(cnt == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.length; i++) {
                sb.append(ans[i]);
                if (i < ans.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
			return;
		}

        for(int i = 0; i<num.length; i++) {
            if(!visit[i]) {
                ans[cnt] = num[i];
                visit[i] = true;
                NM(cnt+1);
                visit[i] = false;
            }

        }
	}

}
