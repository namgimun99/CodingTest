import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int cnt = 0;

        boolean[] visit = new boolean[n];
        boolean[] flag = new boolean[n];
        boolean[] flagA = new boolean[n];

        for(int i = 0; i<num.length; i++){
            flag[i] = true;
            for(int a = 0; a<num.length; a++){

                if(flag[a]) {
                    continue;
                }
                flagA[a] = true;

                int b = num[i] - num[a];

                int left = 0;
                int right = num.length-1;
                int mid = 0;

                while(right >= left){

                    mid = (left + right)/2;

                    if(num[mid] > b) {
                        right = mid-1;
                    } else if(num[mid] < b) {
                        left = mid+1;
                    } else {
                        if(flagA[mid] || flag[mid]) {
                            int r = mid;
                            while((r>= 0 && r<=num.length-1)&& (num[mid] == num[r])) {

                                if((!flag[r] && !flagA[r])) {
                                    visit[i] = true;
                                    break;
                                }
                                r++;
                            }
                            break;

                        } else {
                            visit[i] = true;
                            break;
                        }
                    }
                }
                flagA[a] = false;
            }
            flag[i] = false;
        }

        for(int i = 0; i< visit.length; i++) {
            if(visit[i]) {
                cnt++;
            }
        }

        pw.println(cnt);

        br.close();
        pw.close();

    }
}
