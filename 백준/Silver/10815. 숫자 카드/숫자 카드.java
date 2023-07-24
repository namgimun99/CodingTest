import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] Nnum = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] Mnum = br.readLine().split(" ");
        int[] result = new int[M];

        TreeSet<Integer> Nset = new TreeSet<>();

        for(int i = 0; i<N;i++){
            Nset.add(Integer.parseInt(Nnum[i]));
        }

        for(int i = 0; i<M ; i++){
            if(Nset.contains(Integer.parseInt(Mnum[i]))) {
                result[i] = 1;
            }

            else {
                result[i] = 0;
            }

            pw.print(result[i] + " ");
        }


        pw.close();
        br.close();
    }
}
