import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());
        int limitCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[numCnt];

        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int[] numArr2 = new int[100001];
        int left = 0;

        for(int right = 0; right< numArr.length; right++) {
            numArr2[numArr[right]]++;

            while(numArr2[numArr[right]] > limitCnt) {
                numArr2[numArr[left]]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left+1);
        }

        System.out.println(maxLength);


        br.close();
    }
}
