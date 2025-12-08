import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int dish = Integer.parseInt(st.nextToken());
        int fish = Integer.parseInt(st.nextToken());
        int eatDish = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());
        int max = 0;
        int cnt = 0;

        int[] dishArr = new int[dish*2];
        int[] fishArr = new int[fish+1];

        for(int i = 0 ; i < dish; i++) {
            int fishNumber = Integer.parseInt(br.readLine());
            dishArr[i] = fishNumber;
            dishArr[i+dish] = fishNumber;
        }

        for(int i = 0; i<eatDish; i++) {
            if(fishArr[dishArr[i]] == 0) {
                cnt++;
            }
            fishArr[dishArr[i]]++;
        }

        int startidx = 0;
        int endidx = eatDish-1;

        for(int i = 0; i< dish; i++) {
            if(fishArr[dishArr[startidx]] == 1) {
                cnt--;
            }
            fishArr[dishArr[startidx]]--;
            startidx++;
            endidx++;
            if(fishArr[dishArr[endidx]] == 0) {
                cnt++;
            }
            fishArr[dishArr[endidx]]++;

            if(fishArr[coupon] == 0) {
                max = Math.max(cnt+1, max);
            } else {
                max = Math.max(cnt, max);
            }
        }

        System.out.println(max);

        br.close();
    }
}
