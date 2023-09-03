import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String input = br.readLine();
        int cnt = 0;
        int[] arr = new int[input.length()];

        for(int i = 0; i<input.length()/2; i++){
            if(input.charAt(i) == input.charAt(input.length()-i-1)){
                arr[i] = 1;
                arr[input.length()-i-1] = 1;
            }
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0) {
                cnt++;
            }
        }

        if(cnt > 1){
            pw.println(0);
        } else {
            pw.println(1);
        }


        pw.close();
        br.close();
    }
}
