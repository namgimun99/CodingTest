import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int personA = 0;
        int personB = 0;
        int sum = 0;
        long cnt = 0;
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i< num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        for(int i = 0;i<arr.length-2; i++) {
            personA = i+1;
            personB = arr.length-1;

            while(personA < personB) {
                sum = arr[i] + arr[personA] + arr[personB];

                if (sum == 0) {
                    if (arr[personA] == arr[personB]) {
                        int n = personB - personA + 1; // 같은 값 개수
                        cnt += (long) n * (n - 1) / 2;  // 조합 nC2
                        break; // 끝났으니 while 탈출
                    } else {
                        int leftCnt = 1;
                        int rightCnt = 1;

                        // arr[personA] 중복 개수 세기
                        while (personA + 1 < personB && arr[personA] == arr[personA + 1]) {
                            leftCnt++;
                            personA++;
                        }
                        // arr[personB] 중복 개수 세기
                        while (personB - 1 > personA && arr[personB] == arr[personB - 1]) {
                            rightCnt++;
                            personB--;
                        }

                        cnt += (long) leftCnt * rightCnt;
                        personA++;
                        personB--;
                    }
                } else if(sum < 0){
                    personA++;
                } else if(sum > 0) {
                    personB--;
                }
            }
        }

        System.out.println(cnt);


        br.close();
    }
}
