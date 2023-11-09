import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static List<Integer> list;
    static int[] ans; //정답 배열
    static boolean[] visit; //정답 배열
    static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        ans = new int[m];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
        }

        Collections.sort(list);

        nCr(0);
    }

    private static void nCr(int cnt) { // 갯수와 시작 위치를 넣는다.
        if (cnt == m) { // 갯수만큼 뽑았으면 출력한다.
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< ans.length; i++){
                sb.append(ans[i]);
                if(i<ans.length-1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
            return;
        }

        int before = 0;
        for (int i = 0; i < list.size(); i++) { // 시작위치부터 끝까지 돌린다.
            if(visit[i]){
                continue;
            }

            if(before != list.get(i)){
                ans[cnt] = list.get(i);  // 현재위치의 숫자를 답 배열에 넣는다.
                before = list.get(i);
                nCr(cnt + 1); // 현재 위치를 1 더한 후 다음 숫자를 찾는다.
            }
        }
    }
}