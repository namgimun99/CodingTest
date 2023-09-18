import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] load = new int[N][N];
        int virus;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<Integer, List<Integer>> TempMap = new TreeMap<>();

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j< N; j++) {
                virus = Integer.parseInt(st.nextToken());
                load[i][j] = virus;

                if(virus != 0){
                    map.putIfAbsent(virus,new ArrayList<>());
                    map.get(virus).add(i);
                    map.get(virus).add(j);

                }

            }
        }

        st = new StringTokenizer(br.readLine());

        int goalTime = Integer.parseInt(st.nextToken());
        int goalX = Integer.parseInt(st.nextToken());
        int goalY = Integer.parseInt(st.nextToken());

        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};
        int time = 0;

        while(true) {

            if(time == goalTime || load[goalX-1][goalY-1] > 0) {
                pw.println(load[goalX-1][goalY-1]);
                break;
            }
            
            time++;

            for (int i = 1; i <= K; i++) {
                if(map.containsKey(i)){
                    TempMap.putIfAbsent(i,new ArrayList<>());
                    while(!map.get(i).isEmpty()){
                        int Y = map.get(i).get(map.get(i).size()-1);
                        int X = map.get(i).get(map.get(i).size()-2);

                        map.get(i).remove(map.get(i).size()-1);
                        map.get(i).remove(map.get(i).size()-1);

                        for (int j = 0; j < 4; j++) {
                            int newX = X + x[j];
                            int newY = Y + y[j];
                            if (newX >= 0 && newX < N && newY >= 0 && newY < N && load[newX][newY] == 0) {
                                TempMap.get(i).add(X + x[j]);
                                TempMap.get(i).add(Y + y[j]);
                                load[X + x[j]][Y + y[j]] = i;
                            }
                        }
                    }
                }
            }
            map = new TreeMap<>(TempMap);
            TempMap.clear();
            
        }

        pw.close();
        br.close();
    }
}