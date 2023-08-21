
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> xList = new ArrayList<>();
        int x, y;
        int cnt= 0;



        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(!xList.contains(x)) {
                xList.add(x);
            }
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(y);
        }

        for(int i = 0; i<xList.size()-1; i++){
            if(map.get(xList.get(i)).size() >=2){

                for(int j = i+1; j<xList.size(); j++){
                    if(map.get(xList.get(j)).size() >=2){

                        for(int k = 0; k<map.get(xList.get(i)).size()-1; k++){
                            for(int l = k+1; l<map.get(xList.get(i)).size(); l++) {

                                if(map.get(xList.get(j)).contains(map.get(xList.get(i)).get(k)) && map.get(xList.get(j)).contains(map.get(xList.get(i)).get(l))){
                                    cnt++;
                                }

                            }
                        }



                    }
                }

            }
        }



        pw.println(cnt);

        pw.close();
        br.close();

    }
}
