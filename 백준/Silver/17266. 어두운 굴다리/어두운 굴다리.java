import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] place = new int[m];

        for(int i = 0; i< m; i++) {
            place[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1; // 비출 수 있는 최소 거리
        int end = n; // 비출 수 있는 최대 거리

        while (start <= end) {
            int mid = (start + end) / 2;

            int prev = 0;

            for (int i=0; i<place.length; i++) {
                if (place[i] - mid <= prev) { // 왼쪽 다 비췄음
                    prev = place[i] + mid; // 오른쪽 비추는 거리
                }
            }

            if(n - prev > 0) { // n 보다 비춘 거리가 더 작다 ( 더 비춰야함)
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);


        br.close();
    }
}
