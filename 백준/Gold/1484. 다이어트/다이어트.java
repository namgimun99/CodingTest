import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int g = Integer.parseInt(br.readLine());

        int reWeight = 1;
        int nowWeight = 1;

        List<Integer> list = new ArrayList<>();

        while(true) {

            if(nowWeight*nowWeight - (nowWeight-1)*(nowWeight-1) > g) {
                break;
            }

            if(nowWeight*nowWeight - reWeight*reWeight < g) {
                nowWeight++;
            } else if (nowWeight*nowWeight - reWeight*reWeight > g){
                reWeight++;
            } else {
                list.add(nowWeight);
                nowWeight++;
                reWeight++;
            }
        }

        if(list.isEmpty()) {
            pw.println(-1);
        } else {
            for(int n : list){
                pw.println(n);
            }
        }

        br.close();
        pw.close();
    }
}
