import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        int num = 0;
        int sum = 0;

        for(int i = 1; i<5; i++){
            num = Integer.parseInt(st.nextToken());
            sum = sum + num;
            arr[i] = sum;
        }

        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){

                if(arr[j]-arr[i] < 0){
                    pw.print(-(arr[j]-arr[i]) + " ");
                } else {
                    pw.print(arr[j]-arr[i] + " ");
                }

            }
            pw.println();
        }


        pw.close();
        br.close();

    }
}
