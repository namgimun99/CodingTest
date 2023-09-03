import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        String name = "";

        int[] arr = new int[26];
        List<Character> list = new ArrayList<>();

        for(int i = 0; i< N; i++){
            name = br.readLine();

            arr[name.charAt(0)-97] = arr[name.charAt(0)-97]+1;
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] >=5) {
                list.add((char)(i+97));
            }
        }

        if(list.size() == 0){
            pw.println("PREDAJA");
        } else {
            for(int i = 0; i<list.size(); i++){
                pw.print(list.get(i));
            }
        }
        pw.close();
        br.close();
    }
}
