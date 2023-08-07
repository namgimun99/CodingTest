import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, List<Integer>> arMap = new TreeMap<>();

        int num = Integer.parseInt(br.readLine());

        int time = 0;
        int arTime = 0;
        int cpTime = 0;
        int at = 0;

        for(int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());

            arTime = Integer.parseInt(st.nextToken());
            cpTime = Integer.parseInt(st.nextToken());

            set.add(arTime);
            arMap.putIfAbsent(arTime, new ArrayList<>());
            arMap.get(arTime).add(cpTime);
        }

        time = arMap.firstKey();


        for(List<Integer> n : arMap.values()){
            cpTime = set.pollFirst();
            for(int ti : n){
                if(cpTime <= time) {
                    time = time + ti;
                } else {
                    time = time + (cpTime - time) + ti;
                }
            }
        }

        pw.println(time);
        pw.close();
        br.close();
    }
}
