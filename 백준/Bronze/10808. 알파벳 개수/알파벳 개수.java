import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String N = br.readLine();

        int[] Al= new int[26];
        int num = 0;

        for(int i = 0; i<N.length(); i++) {
            Al[N.charAt(i) - 97] += 1;

        }

        for(int i = 0; i<Al.length; i++){
            pw.print(Al[i] + " ");
        }


        pw.close();
        br.close();
    }
}
