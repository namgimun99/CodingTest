

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        int si,se;

        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            si = Integer.parseInt(st.nextToken());
            se = Integer.parseInt(st.nextToken());

            list.add(si);
            list.add(se);
            set.add(si);
            set.add(se);
        }

        List<Integer> sortlist = new ArrayList<>(set);
        int[] arr = new int[set.size()];

        int start,end;
        for(int h = 0; h<list.size(); h=h+2){
                start = sortlist.indexOf(list.get(h));
                end = sortlist.indexOf(list.get(h+1));

                for(int j = start; j<= end;j++){
                    arr[j] = h;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0;i<arr.length;i++){
            if(!result.contains(arr[i])){
                result.add(arr[i]);
            }
        }

        pw.println(result.size());

        pw.close();
        br.close();


    }
}
