import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int child = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int color = 0;
        int answer = 0;
        int sum = 0;

        List<Integer> colorList = new ArrayList<>();

        for(int i = 0; i<cnt; i++){
            color = Integer.parseInt(br.readLine());
            max = max < color ? color : max;
            colorList.add(color);
        }

        int left = 1;
        int right = max;
        int give = 0;
        int result = Integer.MAX_VALUE;

        while(left <= right) {
            give = (left + right)/2;
            sum = 0;

            for(int i = 0; i<colorList.size(); i++){
                if(colorList.get(i)%give != 0) {
                   answer =  colorList.get(i)/give +1;
                } else {
                    answer =  colorList.get(i)/give;
                }
                sum += answer;
            }

            if(sum <= child) {
                result = Math.min(result, give);
                right = give -1;
            } else {
                left = give +1;
            }
        }

        pw.println(result);

        pw.close();
        br.close();
    }
}
