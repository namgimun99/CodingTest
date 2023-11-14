import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Deque<Integer> numDeq;
    static List<Integer> operList;
    static int[] answer;
    static boolean[] visit;
    static int numCnt;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        numCnt = Integer.parseInt(br.readLine());
        numDeq = new LinkedList<>();
        operList = new ArrayList<>();
        answer = new int[numCnt - 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numDeq.offerLast(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                operList.add(i);
            }
        }
        visit = new boolean[operList.size()];

        nPr(0);

        pw.println(max);
        pw.println(min);

        br.close();
        pw.close();

    }

    public static void nPr(int cnt) {

        if (cnt == (numCnt - 1)) {
            int i = 0;

            Deque<Integer> numDeq2 = new LinkedList<>(numDeq);
            while(true){
                if(numDeq2.size() < 2){
                    int result = numDeq2.pollFirst();
                    max = max > result ? max : result;
                    min = min < result ? min : result;
                    break;
                }
                numDeq2.offerFirst(cal(numDeq2.pollFirst(),numDeq2.pollFirst(),answer[i]));
                i++;
            }

            return;
        }

        for (int i = 0; i < operList.size(); i++) {
            if (!visit[i]) {
                answer[cnt] = operList.get(i);
                visit[i] = true;
                nPr(cnt + 1);
                visit[i] = false;
            }
        }
    }

    public static int cal(int a,int b, int c){
        int result = 0;
        if(c == 0) {
            result = a+b;
        } else if(c == 1) {
            result = a-b;
        } else if(c == 2) {
            result = a*b;
        }else if(c == 3) {
            if(a<0 || b > 0){
                result = -((a*(-1))/b);
            } else {
                result = a/b;
            }

        }

        return result;
    }
}