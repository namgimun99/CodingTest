import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int[] needMoney = new int[cnt];
        int haveMoney = 0;
        int useMoney = 0;
        int min = 0;
        int mid = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<cnt ; i++) {
            needMoney[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,needMoney[i]);
        }

        st = new StringTokenizer(br.readLine());
        haveMoney = Integer.parseInt(st.nextToken());


        while (min<=max) {
            useMoney = 0;
            mid = (min + max) / 2;
            for(int i = 0 ; i<cnt; i++) {
                if(needMoney[i] <= mid) {
                    useMoney += needMoney[i];
                } else {
                    useMoney += mid;
                }
            }

            if(haveMoney >= useMoney) {
                min = mid+1;
            } else if(haveMoney < useMoney) {
                max = mid-1;
            }
        }

        System.out.println(max);

        br.close();
    }
}
