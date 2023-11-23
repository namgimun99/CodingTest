import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] team;
    static int sum;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        int[] ppl = new int[n];
        boolean[] visit = new boolean[n];
        int[][] point = new int[n][n];
        team = new int[n / 2];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            ppl[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team(0, 0, n, ppl, visit, point);

        for(int i = 0; i<list.size()/2; i++){
            int team1 = list.get(i);
            int team2 = list.get(list.size()-1-i);
            if(team1 >= list.get(list.size()-1-i)){
                min = min <= team1 - team2 ? min : team1 - team2;
            } else {
                min = min <= team2 - team1 ? min : team2 - team1;
            }
        }

        pw.println(min);

        br.close();
        pw.close();
    }

    public static void team(int cnt, int start, int n, int[] ppl, boolean[] visit, int[][] point) {
        if (cnt >= n / 2) {
            sum = 0;
            for (int i = 0; i < team.length; i++) {
                for (int j = i + 1; j < team.length; j++) {
                    sum += point[team[i]-1][team[j]-1];
                    sum += point[team[j]-1][team[i]-1];
                }
            }
            list.add(sum);
            return;
        }

        for (int i = start; i < ppl.length; i++) {
            if (!visit[i]) {
                team[cnt] = ppl[i];
                visit[i] = true;
                team(cnt + 1, i + 1, n, ppl, visit, point);
                visit[i] = false;
            }
        }
    }
}
