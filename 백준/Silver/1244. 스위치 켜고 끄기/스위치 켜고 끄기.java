
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switchCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] switchArr = new int[switchCnt+1];

        for(int i = 1; i<= switchCnt; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        int[] sexArr = new int[studentCnt+1];
        int[] numArr = new int[studentCnt+1];

        for(int i = 1; i<= studentCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            sexArr[i] = sex;
            numArr[i] = num;
        }

        for(int i = 1; i<=studentCnt; i++) {
            if(sexArr[i] == 1) {
                int multiply = 1;
                while(numArr[i] * multiply <= switchCnt) {
                    int multiplyNum = numArr[i] * multiply;

                    if(switchArr[multiplyNum] == 0) {
                        switchArr[multiplyNum] = 1;
                    } else {
                        switchArr[multiplyNum] = 0;
                    }

                    multiply++;
                }

            } else { // 여자일 때
                int cnt = 1;
                if(switchArr[numArr[i]] == 0) { // 자기 자신은 무조건 바꿈
                    switchArr[numArr[i]] = 1;
                } else {
                    switchArr[numArr[i]] = 0;
                }
                // 대칭이면 대칭인 부분 바꿈
                while( numArr[i] - cnt >= 1 && numArr[i] + cnt <= switchArr.length-1) {

                    if(switchArr[numArr[i]+cnt] != switchArr[numArr[i]-cnt]) break;
                    if(switchArr[numArr[i]+cnt] == 0) {
                        switchArr[numArr[i]+cnt] = 1;
                        switchArr[numArr[i]-cnt] = 1;
                    } else {
                        switchArr[numArr[i]+cnt] = 0;
                        switchArr[numArr[i]-cnt] = 0;
                    }
                    cnt++;
                }
            }
        }

        for(int i = 1; i< switchArr.length; i++) {
            if( i % 20 != 0) {
                System.out.print(switchArr[i]);
            } else {
                System.out.println(switchArr[i]);
            }

            if(i != switchArr.length-1 && i%20 != 0) {
                System.out.print(" ");
            }

        }

        br.close();
    }
}
