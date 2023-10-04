import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while(start <= end && end <= n) {
            if(sum < k) {
                sum += arr[end++];
            } else if(sum >= k) {
                len = len < end-start ? len : end - start;
                sum -= arr[start++];
            }
        }
        pw.println(len==Integer.MAX_VALUE ? 0 : len);

        pw.close();
        br.close();
    }
}
