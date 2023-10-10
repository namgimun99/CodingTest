import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n+1];

        for(int i = 2; i<= n; i++) {
            arr[i] = i;
        }

        for(int i = 2; i<=n; i++) {

            if (arr[i] !=0) {
                list.add(i);
                for(int j = 1; i*j <= n; j++) {
                    arr[i*j] = 0;
                }
            }
        }

        int start = 0;
        int end = 1;
        int sum = 0;
        int cnt = 0;

        while(true){
            if(end >= list.size() || start > end) {
                break;
            }

            for(int i = start; i<=end; i++){
                sum += list.get(i);
            }

            if(sum > n){
                start++;
            } else if(sum < n) {
                end++;
            } else {
                start++;
                end++;
                cnt++;
            }
            sum = 0;
        }

        if(list.size() == 1) {
            cnt++;
        }
        pw.println(cnt);

        br.close();
        pw.close();
    }
}
