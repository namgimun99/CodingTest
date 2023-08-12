import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String N = br.readLine();

        int[] al= new int[26];
        int num = 0;
        int cnt = 0;
        int a = -1;

        for(int i = 0; i<N.length(); i++) {
            al[N.charAt(i) - 65] += 1;

        }

        for(int i = 0; i<al.length; i++){
            if(al[i]%2 == 1) {
                cnt++;
                al[i] -= 1;
                if(a == -1){
                    a = i;
                }
            }

            if(cnt >= 2) {
                break;
            }
        }

        if(cnt >= 2) {
            pw.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < al.length; i++) {
                if (al[i] % 2 == 0) {
                    for (int j = 0; j < al[i] / 2; j++) {
                        pw.print((char) (i + 65));
                    }
                }
            }

            if(a != -1){
                pw.print((char) (a + 65));
            }


            for (int i = al.length - 1; i >= 0; i--) {
                if (al[i] % 2 == 0) {
                    for (int j = 0; j < al[i] / 2; j++) {
                        pw.print((char) (i + 65));
                    }
                }
            }
        }


        pw.close();
        br.close();
    }
}
